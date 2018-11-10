/*
    Author: John Lorenzo
    Course: CSC260
    Date: 11/11/2018
    Assignment: Objects and Classes; static and non-static members
    This program tests the account class.
    Instructor: Aziz Bahha
*/
import java.util.*;

public class TestAccount {
    public static void main(String[] args) {
        Account account1 = new Account();

        System.out.printf("The average account balance is $%,.2f\n\n", Account.getAverageBalance());
        System.out.println("Default Account:");
        printAccount(account1);

        account1.setId(1122);
        account1.setBalance(20000.0);
        account1.setAnnualInterestRate(4.5);
        System.out.println("Modified account:");
        printAccount(account1);

        account1.withdraw(2500.0);
        account1.deposit(3000.0);
        System.out.println("After withdrawal and deposit:");
        printAccount(account1);

        // Adds 6 months of interest to account1
        for(int i = 0; i < 6; i++){
            account1.awardMontlyInterest();
        }
        System.out.println("After six months of interest:");
        printAccount(account1);
        System.out.printf("\nThe average account balance is $%,.2f\n", Account.getAverageBalance());

        account1.closeAccount();

        // An array of 5 Account objects
        Account[] testAccounts = new Account[5];

        // Initializes accounts in the testAccounts array with IDs 11-15,
        // random balances between $50,000-$150,000, and an interest rate of 3.0%
        for(int i = 0; i < 5; i++){
            double randomAccountBalance = ((Math.random() * 150000.0) + 50000);
            testAccounts[i] = new Account();

            testAccounts[i].setId(i + 11);
            testAccounts[i].setBalance(randomAccountBalance);
            testAccounts[i].setAnnualInterestRate(3.0);
        }

        System.out.println("Array of five accounts with random balances:");

        // Prints all accounts in the testAccounts array
        for(int i = 0; i < testAccounts.length; i++){
            printAccount(testAccounts[i]);
        }
        System.out.printf("\nThe average account balance is $%,.2f\n\n", Account.getAverageBalance());

        // Adds 6 months of interest to all account in the testAccounts array
        for(int i = 0; i < testAccounts.length; i++){
            for(int j = 0; j < 6; j++){
                testAccounts[i].awardMontlyInterest();
            }
        }

        System.out.println("Array after awarding 6 months of interest:");
        for(int i = 0; i < testAccounts.length; i++){
            printAccount(testAccounts[i]);
        }
        System.out.printf("\nThe average account balance is $%,.2f\n", Account.getAverageBalance());
    }

    /**
     * Prints an Account object's id, balance, annual interest rate, and the date it was created
     * @param testAccount This is the Account object that will be printed
     */
    public static void printAccount(Account testAccount){
        System.out.printf("%11d  $%,10.2f %5.2f%% %29s\n",
                testAccount.getId(),
                testAccount.getBalance(),
                testAccount.getAnnualInterestRate(),
                testAccount.getDateCreated()
        );
    }
}
