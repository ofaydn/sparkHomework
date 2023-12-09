package com.example.sparkhadoop.Models;

import lombok.Data;


@Data
public class EmployeeDTO {
    public int empno;
    public String ename;
    public String job;
    public String mgr;
    public String hiredate;
    public int sal;
    public Integer comm;
    public String deptno;
    public String img;

    public EmployeeDTO(){

    }//"empno","ename","job","mgr","hiredate","sal","comm","dept","img"
    public EmployeeDTO(int empno,String ename, String job, String mgr, String hiredate,int sal, Integer comm, String deptno, String img){
        this.empno=empno;
        this.ename =ename;
        this.job=job;
        this.mgr = mgr;
        this.hiredate=hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
        this.img = img;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    public String getDept() {
        return deptno;
    }

    public void setDept(String dept) {
        this.deptno = dept;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
