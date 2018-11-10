/*
    Author: John Lorenzo
    Course: CSC260
    Date: 11/11/2018
    Assignment: Objects and Classes; static and non-static members
    This program replicates an account system.
    Instructor: Aziz Bahha
*/

import java.util.Date;

public class Account {
    private int id = Integer.MAX_VALUE;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated = new Date();
    private static int numberOfAccounts;
    private static double totalValueOfAccounts;

    public Account(){
        numberOfAccounts++;
    }

    public Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;

        numberOfAccounts++;
        totalValueOfAccounts += balance;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
        totalValueOfAccounts += this.balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public void withdraw(double withdrawAmount){
        balance -= withdrawAmount;
        totalValueOfAccounts -= withdrawAmount;
    }

    public void deposit(double depositAmount){
        balance += depositAmount;
        totalValueOfAccounts += depositAmount;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12.0;
    }

    public void awardMontlyInterest(){
        double monthlyInterest = ((getMonthlyInterestRate() / 100) * balance);
        balance += monthlyInterest;
        totalValueOfAccounts += monthlyInterest;
    }

    public void closeAccount(){
        System.out.printf("Closing Account %d\n\n", id);
        numberOfAccounts--;
        totalValueOfAccounts -= balance;
    }

    public static double getAverageBalance(){
        if(numberOfAccounts == 0){
            return 0;
        }

        return totalValueOfAccounts / numberOfAccounts;
    }

}
