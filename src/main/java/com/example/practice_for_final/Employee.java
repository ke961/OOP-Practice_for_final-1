package com.example.practice_for_final;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    private String employeeName;
    private int employeeId;
    private String post;
    private String employeeDepartment;
    private LocalDate DOJ;

    public Employee() {
    }

    public Employee(String employeeName, int employeeId, String post, String employeeDepartment, LocalDate DOJ) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.post = post;
        this.employeeDepartment = employeeDepartment;
        this.DOJ = DOJ;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String employeeSalary) {
        this.post = post;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public LocalDate getDOJ() {
        return DOJ;
    }

    public void setDOJ(LocalDate DOJ) {
        this.DOJ = DOJ;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId=" + employeeId +
                ", post=" + post +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", DOJ=" + DOJ +
                '}';
    }

   public Float getEmployeeSalary(){
        float salary=0;

        String post=this.getPost();
        if(post.equals("Manager")){
            salary=22000;

        } else if (post.equals("GM")) {
            salary=17000;

        }

       return salary;
   }
}
