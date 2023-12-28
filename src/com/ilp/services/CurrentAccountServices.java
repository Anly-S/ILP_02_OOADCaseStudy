package com.ilp.services;

import java.util.Scanner;

import com.ilp.entity.Account;

public class CurrentAccountServices {
	public void displayBalance(Account account) {
		System.out.println("Your current account balance is: Rs."+account.getBalance());
	}
    public void withdrawMoney(Account account) {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("Enter the amount to be withdrawn :");
    	double withdrawAmount=scanner.nextDouble();
    	System.out.println("Amount Rs."+withdrawAmount+" was successful!!!");
    	account.setBalance(account.getBalance()-withdrawAmount);
    	System.out.println("Your current account balance is Rs."+account.getBalance());
    }
    public void cashDeposit(Account account) {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("Enter the amount to be deposited :");
    	double depositAmount=scanner.nextDouble();
    	System.out.println("Amount Rs."+depositAmount+" was successful!!!");
    	account.setBalance(account.getBalance()+depositAmount);
    	System.out.println("Your current account balance is Rs."+account.getBalance());
    }
}
