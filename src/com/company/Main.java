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

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//first class (Main class)
abstract class Account_holder{

    Random Random_Value_for_Account_number = new Random();//random value for account number
    Scanner Scanner_For_Account_Holder_Information = new Scanner(System.in);//scanner for account holder information

    String Account_Holder_Name;//variables//
    String Account_Type;
    Long Account_Number = (Long)(Random_Value_for_Account_number.nextLong()%100000000)+1000000000000000000L;
    double Balance_of_Account;
    double Minimum_balance;
    double Service_charges;

    public Account_holder(String Account_Holder_Name_of_constructer_parameter,String Account_Type_of_constructer_parameter){
        this.Account_Holder_Name = Account_Holder_Name_of_constructer_parameter;
        this.Account_Type = Account_Type_of_constructer_parameter;
    }
    abstract public String toString();
}
//Second Class (Derived class 1 and derived from first class account holder)
class Saving_Account extends Account_holder{

    public Saving_Account(double Balance_Of_Account,double Minimum_balance,double Service_charges){
        super("jafafr","cur");
        this.Balance_of_Account = Balance_Of_Account;
        this.Minimum_balance = Minimum_balance;
        this.Service_charges = Service_charges;
    }

    public String toString(){
        return "Account Holder Name : "+Account_Holder_Name+"\n"+"Account Type : "+Account_Type+"\nAccount Number : "+Account_Number;
    }
    //Method 1
    void Simple_interest(double interest,int time_per_year){
        //A = P(1 + rt)
         double Simple_Interest = this.Balance_of_Account*(1+interest*time_per_year);
         System.out.println("Interset Rate : "+interest+"\n\nInterst per "+time_per_year+" year is = "+Simple_Interest);
    }
    //Method 2
    void Deposit_Payment(double Payment_for_Deposit){
        double Payment_after_Desposit=Balance_of_Account+Payment_for_Deposit;
        System.out.println("Your Balance For Deposit is = "+Payment_for_Deposit+"\n\nYou Current Balance is = "+Balance_of_Account+"\n\nYou New Balance is = "+Payment_after_Desposit);
    }
    //Method 3
    void Payment_for_WithDraw(double Payment_to_With_Draw){
         double Payment_after_With_Draw = Balance_of_Account - Payment_to_With_Draw;
         if(Payment_to_With_Draw > Balance_of_Account){
             System.out.println("You donot have enought Balance !!!!\n\nYour Wanted Balance for With draw is = "+Payment_to_With_Draw+"\n\nYour Current Balance is = "+Balance_of_Account);
             System.out.println("You Have Alert !!!!!!!\n\n");
             Check_for_Minimum_Balance(this.Minimum_balance,this.Service_charges);
         }
         else{
             System.out.println("Your Old Balance is = "+Balance_of_Account+"\n\nYou With Draw = "+Payment_to_With_Draw+"Your new Balance is = "+Payment_after_With_Draw+"\n\n\t\t\tHappy Banking!!!!!!!!");
         }
    }
    //Method 4 (SubMethod)
    void Check_for_Minimum_Balance(double Minimum_balance_check_for_method,double Service_charges_check_for_method){
         if(Balance_of_Account < Minimum_balance_check_for_method){
            System.out.println("Your Balance is ower Then The Appropiate Balance\n\n (Minimum balance = "+Minimum_balance_check_for_method+")\n\n konw You Have to Pay The Service Charge = "+Service_charges_check_for_method);
         }
         else{
             System.out.println("Your Balance is Following the Rule is under Minimum Balance");
         }
    }
    //Method 5
    // this for selecter of method through switch cases
    void Selection_Of_Methods_Of_Banking(){
        Scanner Scanner_For_Method_Selection = new Scanner(System.in);

        System.out.println("Its a Current Account of "+this.Account_Holder_Name+"\n\nFor Interest Rate type I\nFor With Draw type W\nFor Deposit type D");
        System.out.print("Enter");
        char Selecter_Character = Scanner_For_Method_Selection.next().charAt(0);
        switch (Selecter_Character){
            case 'I':
                Simple_interest(0.324,1);
                break;
            case 'W':
                Payment_for_WithDraw(500);
                break;
            case 'D':
                Deposit_Payment(1000);
                break;
            default:
                Selection_Of_Methods_Of_Banking();
                break;
        }
    }
}
//Third Class (Derived class 2 and derived from first class account holder)
class Current_Account extends Account_holder{
    double Balance_of_Account;
    double Minimum_balance=100;
    double Service_charges=500;


    public Current_Account(double Balance_Of_Accounts){
        super("jafafr","cur");
        this.Balance_of_Account = Balance_Of_Accounts;
    }

      //String method is called 2 times
    public String toString(){
        return "Account Holder Name : "+Account_Holder_Name+"\n"+"Account Type : "+Account_Type+"\nAccount Number : "+Account_Number;
    }
    //Method 1
    void Deposit_Payment(double Payment_for_Deposit){
        double Payment_after_Desposit=Balance_of_Account+Payment_for_Deposit;
        System.out.println("Your Balance For Deposit is = "+Payment_for_Deposit+"\n\nYou Current Balance is = "+Balance_of_Account+"\n\nYou New Balance is = "+Payment_after_Desposit);
    }
    //Method 2
    void Payment_for_WithDraw(double Payment_to_With_Draw){
        double Payment_after_With_Draw = Balance_of_Account - Payment_to_With_Draw;
        if(Payment_to_With_Draw > Balance_of_Account){
            System.out.println("You donot have enought Balance !!!!\n\nYour Wanted Balance for With draw is = "+Payment_to_With_Draw+"\n\nYour Current Balance is = "+Balance_of_Account);
            System.out.println("You Have Alert !!!!!!!\n\n");
            Check_for_Minimum_Balance(this.Minimum_balance,this.Service_charges);
        }
        else{
            System.out.println("Your Old Balance is = "+Balance_of_Account+"\n\nYou With Draw = "+Payment_to_With_Draw+"Your new Balance is = "+Payment_after_With_Draw+"\n\n\t\t\tHappy Banking!!!!!!!!");
        }
    }
    //Method 3 (SubMethod)
    void Check_for_Minimum_Balance(double Minimum_balance_check_for_method,double Service_charges_check_for_method){
        if(Balance_of_Account < Minimum_balance_check_for_method){
            System.out.println("Your Balance is ower Then The Appropiate Balance\n\n (Minimum balance = "+Minimum_balance_check_for_method+")\n\n konw You Have to Pay The Service Charge = "+Service_charges_check_for_method);
        }
        else{
            System.out.println("Your Balance is Following the Rule is under Minimum Balance");
        }
    }

    //Method 4 this for selecter of method through switch cases
    void Selection_Of_Methods_Of_Banking(){
        Scanner Scanner_For_Method_Selection = new Scanner(System.in);

        System.out.println("Its a Current Account of "+this.Account_Holder_Name+"\n\nFor With Draw type W\nFor Deposit type D");
        System.out.print("Enter");
        char Selecter_Character = Scanner_For_Method_Selection.next().charAt(0);
        switch (Selecter_Character){
            case 'W':
                Payment_for_WithDraw(500);
                break;
            case 'D':
                Deposit_Payment(1000);
                break;
            default:
                Selection_Of_Methods_Of_Banking();
                break;
        }
    }
}

class Data_base_log_class {
    Scanner Scanner_for_Account_type_selection = new Scanner(System.in);

    void First_Account_Method_Current_Account() {
        ArrayList<Current_Account> HUm = new ArrayList<Current_Account>(4);

        for (int i = 0; i < 4; i++) {
            Current_Account Current_account_Array = new Current_Account(100000);
            System.out.println(i + 1);
            Current_account_Array.Selection_Of_Methods_Of_Banking();
        }
    }

    void Second_Account_Method_Saving_Account() {
        ArrayList<Saving_Account> HUm = new ArrayList<Saving_Account>(4);

        for (int i = 0; i < 4; i++) {
            Saving_Account Saving_Account_Array = new Saving_Account(10000, 200, 500);
            System.out.println(i + 1);
            Saving_Account_Array.Selection_Of_Methods_Of_Banking();
        }
    }

    void Display_Of_Accounts() {
        System.out.println("Select Your Account Types \n\nS for Saving\nC for Current");

        System.out.print("Enter : ");
        char Selecter_Of_Accounts = Scanner_for_Account_type_selection.next().charAt(0);

        switch (Selecter_Of_Accounts) {
            case 'S':
                First_Account_Method_Current_Account();
                break;
            case 'C':
                Second_Account_Method_Saving_Account();
                break;
            default:
                Display_Of_Accounts();
                break;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Data_base_log_class Object_Of_Data_Class = new Data_base_log_class();
        Object_Of_Data_Class.Display_Of_Accounts();
    }
}
