package com.company;

//this is Qusetion 1
/*A bank maintains two kinds of accounts – Savings account and Current account. The
savings account provides simple interest, deposit and withdrawal facilities. The
current account only provides deposit and withdrawal facilities. Current account
holders should also maintain minimum balance. If balance falls below minimum
level a service charge is imposed. Create an abstract class Account that stores
customer name, account number type of account and abstract methods. From this
derive the classes Curr_Account (double balance, double min_bal, double
serviceCharge / penalty) and and Sav_Account (double balance). Include the
necessary methods in order to achieve the following:
1. Define parameterized constructor in a class hierarchy.
2. Allow deposit and update the balance.
3. Display the balance.
4. Compute interest and add to balance.
5. Permit withdrawal and update the balance (check for minimum balance).
6. Apply polymorphism if required for methods in class hierarchy.
7. Create an array of super class / object and populate with subclass objects and
call the overridden / object methods.
8. Write a test program to demonstrate the above said implementations.*/

//in this question there is a example of bank account
//Concept in this Question :
/*  1)Abstract classes
    2)inheritance and its types(single,multiple,hierarchy)
    3)Polymorphism(If needed)
*/



//***************************************************************************************************************************************************
//                                                      *****************Start******************

import java.util.Random;
import java.util.Scanner;

//first class (Main class)
abstract class Account_holder{

    Random Random_Value_for_Account_number = new Random();//random value for account number
    Scanner Scanner_For_Account_Holder_Information = new Scanner(System.in);//scanner for account holder information

    String Account_Holder_Name;
    String Account_Type;
    Long Account_Number = (Long)(Random_Value_for_Account_number.nextLong()%100000000)+1000000000000000000L;

    public Account_holder(String Account_Holder_Name_of_constructer_parameter,String Account_Type_of_constructer_parameter){
        this.Account_Holder_Name = Account_Holder_Name_of_constructer_parameter;
        this.Account_Type = Account_Type_of_constructer_parameter;
    }
    abstract public String toString();
}
//Second Class (Derived class 1 and derived from first class account holder)
class Current_Account extends Account_holder{

    double Balance_of_Account;
    double Minimum_balance;
    double Service_charges;

    public Current_Account(double Balance_Of_Account,double Minimum_balance,double Service_charges){
        super("jafafr","cur");
        this.Balance_of_Account = Balance_Of_Account;
        this.Minimum_balance = Minimum_balance;
        this.Service_charges = Service_charges;
    }

    public String toString(){
        return null;
    }
    //Method 1
    void Simple_interest(double interest){

    }
    //Method 2
    void Deposit_Payment(){}
    //Method 3
    void Payment_With_Draw(){}
}
//Third Class (Derived class 2 and derived from first class account holder)
class Saving_Account{}


public class Main {

    public static void main(String[] args) {

    }
}
