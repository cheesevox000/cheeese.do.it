package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Employee {
 
    String ID;
    String name;
    String address;
    double salary ;
    double allowance;
    double total = salary + allowance;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        String regex = "[S][E][0-9]{6}";
        if (ID.matches(regex)) {
            this.ID = ID;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!ID.isEmpty()) {
            this.name = name;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!ID.isEmpty()) {
            this.address = address;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (!ID.isEmpty()) {
            this.salary = salary;
        }
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        if (!ID.isEmpty()) {
            this.allowance = allowance;
        }
    }

    public void printEmployee() {
        System.out.println();
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Salary: " + this.salary);
        System.out.println("Allowance: " + this.allowance);
    }

    public void printwages() {
        System.out.println();
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Salary: " + this.salary);
        System.out.println("Allowance: " + this.allowance);
        System.out.println("Total: " + this.total);
    }
}
