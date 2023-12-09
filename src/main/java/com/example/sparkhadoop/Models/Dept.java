package com.example.sparkhadoop.Models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {
    public int deptno;
    public String dname;
    public String loc;

    public Dept(){}

    public Dept(int deptno,String dname,String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
