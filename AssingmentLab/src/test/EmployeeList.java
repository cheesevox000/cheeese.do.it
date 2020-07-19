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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeList implements I_List{

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

    @Override
    public int find(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(code)) {
                return i;   // if true return i
            }
        }
        return -1;  //but false we return -1, not found
    }

    @Override
    public void add() {
         Employee obj = new Employee();
        System.out.println();
        System.out.print("Code: ");
        obj.setID(sc.nextLine());
        System.out.print("Name: ");
        obj.setName(sc.nextLine());
        System.out.print("Address");
        obj.setAddress(sc.nextLine());
        try {       
            System.out.print("Salary: ");
            obj.setSalary(Double.parseDouble(sc.nextLine()));
            System.out.print("Allowance: ");
            obj.setAllowance(Double.parseDouble(sc.nextLine()));
            if (obj.getSalary() < 0 || obj.getAllowance() < 0) {
                System.out.println("Input Error salary or allowance");  
                return;
            }
        } catch (Exception e) {
            System.err.println("Input Error");
            return;
        }
        if (find(obj.getID()) == -1) {
            list.add(obj);
            System.out.println("Added");
        } else {
            System.out.println("Err Code");
            return;
        }
    }

    @Override
    public void remove() {
        System.out.print("Enter code to Remove: ");
        String code = sc.nextLine();    //input code for remove
        if (find(code) == -1) {
            System.err.println("No employee with that code to remove"); // .err. red word
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
        String code = sc.nextLine();    // input a code for update
        if (find(code) == -1) {
            System.err.println("No employee with that code to update"); // .err. red word
            return;
        } else {
            int i = find(code);
            Employee obj = new Employee();
            obj.setID(list.get(i).getID()); //set a clock found
            System.out.print("Name: ");
            obj.setName(sc.nextLine());     //set a maker
            try {   
                System.out.print("Salary: ");
                obj.setSalary(Double.parseDouble(sc.nextLine()));   // parse to int
                System.out.print("Allowance: ");
                obj.setAllowance(Double.parseDouble(sc.nextLine()));  // parse int for price
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

        // for compare clock and next clock 
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
