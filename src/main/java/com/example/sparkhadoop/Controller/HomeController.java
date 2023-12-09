package com.example.sparkhadoop.Controller;

import com.example.sparkhadoop.Models.Employee;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.apache.spark.sql.functions.col;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getEmp(Model model){

        SparkSession sparkSession = SparkSession.builder()
                .appName("sparkHadoop")
                .master("local[*]")
                .getOrCreate();
        Dataset<Row> empDS = sparkSession.read()
                .option("header","true")
                .csv("hdfs://127.0.0.1:9000/user/hadoop/app/csv/emp.csv");
        Dataset<Row> deptDS = sparkSession.read()
                .option("header","true")
                .csv("hdfs://127.0.0.1:9000/user/hadoop/app/csv/dept.csv");

        // Join for mgr's name with alias
        Dataset<Row> empsManager = empDS.select("empno","ename").withColumnRenamed("ename","mgr_name").withColumnRenamed("empno","employeeno");
        Dataset<Row> empWithMgrNamesDF = empDS.join(empsManager, col("mgr").cast("int").equalTo(col("employeeno")), "left_outer");

        // Join for dname with alias
        Dataset<Row> deptWithAliasDF = deptDS.select("deptno", "dname").withColumnRenamed("deptno","departmantno");

        Dataset<Row> empWithDeptDF = empWithMgrNamesDF.join(deptWithAliasDF, col("deptno").equalTo(col("departmantno")), "left_outer").select(
                "empno","ename","job","mgr_name","hiredate","sal","comm","dname","img"
        );


        Encoder<Employee> employeeEncoder = Encoders.bean(Employee.class);
        List<Employee> employeeList = empWithDeptDF.map((MapFunction<Row, Employee>) val ->new Employee(
                Integer.parseInt(val.getString(0)), //empno
                val.getString(1),                   //ename
                val.getString(2),                   //job
                (val.getString(3)!=null) ? val.getString(3) :null,                  //mgr's name
                val.getString(4),                   //hiredate
                Integer.parseInt(val.getString(5)), //sal
                (val.getString(6) !=null) ? Integer.parseInt(val.getString(6)) : null, //comm
                val.getString(7),                  //dname
                val.getString(8)                    //img
        ),employeeEncoder).collectAsList();

        model.addAttribute("employeeList",employeeList);
        return "index";
    }
}