package com.example.sparkhadoop.Models;

import lombok.Data;

@Data
public class EmpDTO {
    public int empno;
    public String ename;
    public String job;
    public String mname;
    public String hiredate;
    public int sal;
    public Integer comm;
    public String dname;
    public String img;


    public EmpDTO(){

    }

    public EmpDTO(int empno, String ename, String job, String mname, String hiredate, int sal, Integer comm, String dname, String img){
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mname = mname;
        this.dname = dname;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.img = img;
    }
}
