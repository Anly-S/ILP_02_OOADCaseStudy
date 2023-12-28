package com.ilp.services;

import java.util.Scanner;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Account;

public class LoanAccountServices {
	public void displayBalance(Account account) {
		System.out.println("Your current account balance is: Rs."+account.getBalance());
	}
	public void cashDeposit(Account account) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to be deposited :");
		double depositAmount=scanner.nextDouble();
		System.out.println("Amount Rs."+depositAmount+" deposit through cash was successful!!!");
		account.setBalance(account.getBalance()+depositAmount);
		System.out.println("Your current account balance is Rs."+account.getBalance());
	}
	public void chequeDeposit(Account account) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to be deposited :");
		double depositAmount=scanner.nextDouble();
		double rate=0.03*depositAmount;
		depositAmount=depositAmount-rate;
		System.out.println("Amount Rs."+depositAmount+" deposit through cheque was successful!!!");
		account.setBalance(account.getBalance()+depositAmount);
		System.out.println("Your current account balance is Rs."+account.getBalance());
	}

}
