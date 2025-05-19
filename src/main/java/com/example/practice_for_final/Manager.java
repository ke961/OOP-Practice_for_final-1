package com.example.practice_for_final;

import java.time.LocalDate;

public class Manager extends Employee {

   protected Float employeeSalary;

    public Manager(Float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Manager(String employeeName, int employeeId, String post, String employeeDepartment, LocalDate DOJ, Float employeeSalary) {
        super(employeeName, employeeId, post, employeeDepartment, DOJ);
        this.employeeSalary = employeeSalary;
    }

    public Float getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeSalary=" + employeeSalary +
                '}';
    }
}
