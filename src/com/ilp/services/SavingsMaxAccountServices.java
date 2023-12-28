package com.ilp.services;

import java.util.Scanner;
import com.ilp.entity.Account;
import com.ilp.entity.SavingsMaxAccount;
public class SavingsMaxAccountServices {
 
	public void displayBalance(Account account) {
		System.out.println("Your current account balance is: Rs."+account.getBalance());
	}
	public void cashDeposit(Account account) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to be deposited :");
		double depositAmount=scanner.nextDouble();
		if(depositAmount < 1000)
			System.out.println("Sorry! A mininmum balance of Rs 1000 should be maintained in the account.\r\n"
					+ "");
		System.out.println("Amount Rs."+depositAmount+"through cash was successful!!!");
		account.setBalance(account.getBalance()+depositAmount);
		System.out.println("Your current account balance is Rs."+account.getBalance());
	}
	public void withdrawMoney(Account account,double minimumBalance) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to be withdrawn :");
		double withdrawAmount=scanner.nextDouble();
		if(account.getBalance() < minimumBalance+withdrawAmount)
			System.out.println("Sorry! A mininmum balance of Rs 1000 should be maintained in the account.\r\n"
					+ "");
		else
		{
		  System.out.println("Amount Rs."+withdrawAmount+" withdrawal successful!!!");
		  account.setBalance(account.getBalance()-withdrawAmount);
		  System.out.println("Your current account balance is Rs."+account.getBalance());
		}
	}
}
