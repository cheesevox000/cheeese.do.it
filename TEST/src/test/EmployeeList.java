package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE140279
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeList implements I_List {

    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> list = new ArrayList<>();
    
    int count = 0;
    public void sort() {
        Collections.sort(list, new EmployeeComparator());
    }

    public void output() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).printEmployee();
        }
        if (list.isEmpty()) {
            System.err.println("No Employee insize");
        }
    }
   public void output2() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).printwages();
        }
        if (list.isEmpty()) {
            System.err.println("No Employee insize");
        }
    }

    @Override
    public int find(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(code)) {
                return i;
            }
        }
        return -1;
    }
 public Employee inputEmploy(String ID) {
        Employee obj = new Employee();
        obj.setID(ID);
        System.out.print("Name: ");
        obj.setName(sc.nextLine().trim().toUpperCase());
        System.out.print("Address: ");
        obj.setAddress(sc.nextLine().trim().toUpperCase());
        System.out.print("Salary: ");
        obj.setSalary(Double.parseDouble(sc.nextLine()));
        System.out.print("Allowance: ");
        obj.setAllowance(Double.parseDouble(sc.nextLine()));
        return obj;
    }
     @Override
 public void addfirst(){
        Employee obj = new Employee();
        Employee s1= new Employee("Se140279", "Vo Ngoc Minh Tri", "quan 9", 123.123, 2.1);
        Employee s2= new Employee("Se140280", "Vo Thi Thu Truc", "quan 1", 15.23, 7.3);
        Employee s3= new Employee("Se140281", "Vo Thi Ngoc Trinh", "quan 4", 23.23, 6.1);
        list.add(s1);
        list.add(s2);
        list.add(s3);
 }
    @Override
    public void add() {
        Employee obj = new Employee();
        System.out.println();
        try {
            System.out.print("ID: ");
            String ID = sc.nextLine().trim().toUpperCase();
            obj = inputEmploy(ID);
        } catch (Exception e) {
            System.out.println("Error input.");
            return;
        }
   if (obj.getID().isEmpty()) {
            System.out.println("Error input.");
            return;
        }

        if (find(obj.getID()) > -1) {
            System.out.println("Duplicate ID");
            return;
        }

        list.add(obj);
        System.out.println("Added");

    }

    @Override
    public void remove() {
        System.out.print("Enter code to Remove: ");
        String code = sc.nextLine();
        if (find(code) == -1) {
            System.err.println("No employee with that code to remove");
            return;
        } else {
            int i = find(code);
            list.remove(i);
            System.out.println("Removed");
        }
    }

    @Override
    public void update() {
        System.out.print("Enter code employee to Update: ");
        String code = sc.nextLine();
        if (find(code) == -1) {
            System.err.println("No employee with that code to update");
            return;
        } else {
            int i = find(code);
            Employee obj = new Employee();
            obj.setID(list.get(i).getID());
            System.out.print("Name: ");
            obj.setName(sc.nextLine());
            try {
                System.out.print("Salary: ");
                obj.setSalary(Double.parseDouble(sc.nextLine()));
                System.out.print("Allowance: ");
                obj.setAllowance(Double.parseDouble(sc.nextLine()));
                if (obj.getSalary() < 0 || obj.getAllowance() < 0) {
                    System.out.println("Input Error");
                    return;
                }

            } catch (Exception e) {
                System.err.println("Input Error");
                return;
            }
            list.set(i, obj);
            System.out.println("Updated");
        }
    }

    class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee x, Employee y) {
            double salary = x.getSalary();
            double nextsalary = y.getSalary();

            if (salary > nextsalary) {
                return 1;
            }
            if (salary < nextsalary) {
                return -1;
            }
            return 0;
        }
    }
}
