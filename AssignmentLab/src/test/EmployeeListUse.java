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
public class EmployeeListUse {
   public static void main(String args[]){
       I_Menu menu = new Menu();
       menu.addItem("Add new Employee");
       menu.addItem("Update a employee");
       menu.addItem("Print list total");
       menu.addItem("Remove a emplpyee");
       menu.addItem("Print list");
       menu.addItem("Others: Quit");
       int choice;
       I_List list = new EmployeeList();
       do{
           choice= menu.getChoice();
           switch(choice){
               
               case 1: list.add(); break;
               case 2: list.update();break;
               case 3: list.update();break;
               case 4: list.remove();break;
               case 5: list.sort(); list.output();break;
           }
       }
       while (choice>=0 && choice<=5);
   }   
}
