package com.company;


//Question 2

/*
* Define a interface EMPInterface (void displayEMP(), void giveBonus (double
amount)). Define an abstract class Employee(empID, fName, lName, salary). Define
a concrete class Manager (noOfOtockOptions), subclass of Employee and define
interface methods.
Perform the following
1. Define appropriate constructors in a class hierarchy.
2. Ensure the bonus amount should not be negative and zero using exception
handling mechanism (use throws and throw clauses of exception handling).
3. Create array of interface reference variables and populate with manager
objects.
4. Write a test program to implement the above said requirements of interface
implementation and exception handling.*/


//in this question there is a example of Employ
//Concept in this Question :
/*  1)Abstract classes
    2)inheritance and its types(single,multiple,hierarchy,multi)
    3)Interface
*/

import java.util.ArrayList;
import java.util.Scanner;

//interface 1
//only containg method declaration
interface Employ_Interface{
    void Display_Employ();//interface methods
    void Give_Bouns_to_Employ(double Ammount_to_given);//interface method
}


//abstract class 1
//intanace variable
//and a contructer
abstract class Employ{
    String Employ_Id;//variable
    String First_Name;//variable
    String Last_Name;//variable
    double Salary;//variable

    //constructer
    // Define appropriate constructors in a class hierarchy.
    public Employ(String Employ_id_for_Contacter,String First_name_for_Contacter,String Last_name_for_Contacter,double salary_for_Contacter){
        this.Employ_Id = Employ_id_for_Contacter;
        this.First_Name = First_name_for_Contacter;
        this.Last_Name = Last_name_for_Contacter;
        this.Salary = salary_for_Contacter;
    }
}
//sub class 1
//it implement the iterface and extend s the abstract class so its show the behavier of multi inheritance
class Manager extends Employ implements Employ_Interface {
    Scanner scanner_for_Employ_bonus = new Scanner(System.in);
    //contructer and super class contructer
    // Define appropriate constructors in a class hierarchy.
    Manager(String Employ_id_for_Contacter,String First_name_for_Contacter,String Last_name_for_Contacter,double salary_for_Contacter){
        super( Employ_id_for_Contacter, First_name_for_Contacter, Last_name_for_Contacter, salary_for_Contacter);
        Display_Employ();
        System.out.print("Enter Bounus :");
        double Bonus = scanner_for_Employ_bonus.nextDouble();
        Give_Bouns_to_Employ(Bonus);
    }

    //Interface 1 method
    @Override
    public void Display_Employ() {
        System.out.println("Id : "+this.Employ_Id+"\nName : "+this.First_Name+" "+this.Last_Name+"\nSalary : "+this.Salary);
    }
    //Interface 1 method
    //Ensure the bonus amount should not be negative and zero using exception
    //handling mechanism (use throws and throw clauses of exception handling).
    @Override
    public void Give_Bouns_to_Employ(double Ammount_to_given)throws IllegalArgumentException{
        try {
            if(Ammount_to_given <= 0){
                throw new IllegalArgumentException();
            }
            else{
                double Increasement_of_salary = Ammount_to_given + this.Salary;
                System.out.println("You Bonus is : "+Ammount_to_given+"\n\nYour new Salry is + "+Ammount_to_given+" Bouns is : "+Increasement_of_salary);
            }
        }
        catch (Exception e){
            System.out.println("Error : "+e);
        }
    }
}
//test class for array of object
//class 2
//Create array of interface reference variables and populate with manager
//objects.
class data_back_log{

    public void Data_exicuter(){
        ArrayList<Employ_Interface> Employ_Holder_array =new ArrayList<Employ_Interface>(5);
        for (int i = 0; i < 5; i++) {
            Employ_Holder_array.add(new Manager("Fa19-bsse-000","jaffar","Abbas",4000));
        }
    }
}
//main class
public class Question_2 {
    public static void main(String[] args) {
        //there are one interface one abstract class one test class containing Array of objects
        data_back_log object_of_test_class = new data_back_log();
        object_of_test_class.Data_exicuter();
    }
}
