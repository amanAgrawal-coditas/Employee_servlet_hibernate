package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeDetails
{
    public EmployeeDetails() {
    }

    public EmployeeDetails(int id, String ename, String enumber) {
        this.id = id;
        this.ename = ename;
        this.enumber = enumber;
    }

    @Id
    @GeneratedValue
    int id;

    String ename;
    String enumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEnumber() {
        return enumber;
    }

    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }



}