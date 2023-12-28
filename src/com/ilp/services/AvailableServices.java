package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;
import com.ilp.services.*;

public class AvailableServices{

	public static void createService(ArrayList<Service> serviceList) {
		Scanner scanner=new Scanner(System.in);
		char choice;
		do {
		System.out.println("Enter the service code:");
		String serviceCode=scanner.next();
		System.out.println("Enter the service name:");
		String serviceName=scanner.next();
		System.out.println("Enter the service rate:");
		double serviceRate=scanner.nextDouble();
		Service service=new Service(serviceCode,serviceName,serviceRate);
		serviceList.add(service);
		System.out.println("Do you want to add more services?(y/n): ");
		choice=scanner.next().charAt(0);
	}while(choice=='y');
		
	}
	public static void createProduct(ArrayList<Service> serviceList,ArrayList<Product> productList)
	{
		Product product = null;
		Scanner scanner=new Scanner(System.in);
		char choice;
		do {
		ArrayList<Service> productServices=new ArrayList<Service>();
		System.out.println("Enter the product code:");
		String productCode=scanner.next();
		System.out.println("Enter the product name:");
		String productName=scanner.next();
		char serviceChoice;
		
		   for(Service service:serviceList) {
			   System.out.println("Do you want to add "+service.getServiceName()+" (y/n):");
			   serviceChoice=scanner.next().charAt(0);
			   if(serviceChoice=='y')
				   productServices.add(service); 
		   }
		   if(productName.equalsIgnoreCase("SavingsMaxAccount")){
			   product = new SavingsMaxAccount(productCode,productName,productServices);
			   productList.add(product);
		   }
		   else if(productName.equalsIgnoreCase("CurrentAccount")) {
			   product = new CurrentAccount(productCode,productName,productServices);
			   productList.add(product);
		   }
		   else if(productName.equalsIgnoreCase("LoanAccount")) {
			   product = new LoanAccount(productCode,productName,productServices);
			   productList.add(product);
		   }
		System.out.println("Do you want to add more products?(y/n): ");
		choice=scanner.next().charAt(0);
	
	}while(choice=='y');
		
  }
	public static Customer createCustomer(Customer customer,ArrayList<Product> productList) {
		ArrayList<Account> accountList=null;
		Scanner scanner=new Scanner(System.in);
//		System.out.println("Enter customer Id: ");
//		String customerId=scanner.next();
		if(customer==null)
		{
			accountList=new ArrayList<Account>();
			System.out.println("Enter the Customer Code:");
			String customerCode=scanner.next();
			System.out.println("Enter the Customer Name: ");
			String customerName=scanner.next();
			Account account=createAccount(productList);
			accountList.add(account);
			customer=new Customer(customerCode,customerName,accountList);
			
		}
		else
		{
			accountList=customer.getAccountList();
			Account account=createAccount(productList);
			accountList.add(account);
			
		}
		return customer;
		
	}

	public static Account createAccount(ArrayList<Product> productList) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("****Accounts Available***********");
		int index=1;
		for(Product product:productList)
		{
			System.out.println((index++)+"."+product.getProductName());
		}
		System.out.println("Enter Your choice:");
		int accountChoice=scanner.nextInt();
		Product product=productList.get(accountChoice-1);
		System.out.println("Enter the account no.:");
		String accountNo=scanner.next();
		System.out.println("Enter the account balance: ");
		double accountBal=scanner.nextDouble();
		if(product instanceof SavingsMaxAccount)
		{
			while(accountBal<1000)
			{
				System.out.println("Sorry!! a minimum balance of Rs.1000 should be maintained");
				System.out.println("Enter the account balance: ");
			    accountBal=scanner.nextDouble();
			}
		}
		Account account=new Account(accountNo,product.getProductName(),accountBal,product);
		return account;
		
	}
	public static void manageAccounts(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		SavingsMaxAccountServices serviceOne=new SavingsMaxAccountServices();
		CurrentAccountServices serviceTwo=new CurrentAccountServices();
		LoanAccountServices serviceThree=new LoanAccountServices();
		
		int serviceChoice;
        System.out.println("Enter the customer Id : ");
        String customerCode=scanner.next();
        if(customerCode.equalsIgnoreCase(customer.getCustomerCode()))
        {
        	System.out.println(customer.getCustomerName()+" has following accounts :");
        	int index=1;
        	for(Account account:customer.getAccountList())
        	{ 
        		System.out.println((index++)+"."+account.getAccountType());
        	}
        	System.out.println("Enter your choice:");
        	int choice=scanner.nextInt();
        	Account account=customer.getAccountList().get(choice-1);
        	if(account.getAccountType().equalsIgnoreCase("SavingsMaxAccount"))
        	{
        	 System.out.println("Enter your choice: ");
        	 System.out.println("1.Deposit	2. Withdraw  3.Display Balance");
        	 serviceChoice=scanner.nextInt();
        	  switch(serviceChoice)
        	  {
        	   case 1:
        	         serviceOne.cashDeposit(account);
        	         break;
        	   case 2:
        		     double minimumBalance=((SavingsMaxAccount) account.getProduct()).getMinimumBalance();
        		     serviceOne.withdrawMoney(account,1000);
        	        break;
        	   case 3:
        		     serviceOne.displayBalance(account);
  	                 break;
        	   }
        	}
        	else if(account.getAccountType().equalsIgnoreCase("CurrentAccount"))
        	{
        	 System.out.println("Enter your choice: ");
           	 System.out.println("1.Deposit	2. Withdraw  3.Display Balance");
           	 serviceChoice=scanner.nextInt();
           	 switch(serviceChoice)
           	 {
            	case 1:
            		serviceTwo.cashDeposit(account);
	                break;
	            case 2:
	            	serviceTwo.withdrawMoney(account);
	                break;
	            case 3:
	            	 serviceTwo.displayBalance(account);
	                 break;
           	 }
        	}
        	else if(account.getAccountType().equalsIgnoreCase("LoanAccount"))
        	{
        	 System.out.println("Enter your choice: ");
           	 System.out.println("1.Cheque deposit	2.Cash deposit  3.Display Balance");
           	 serviceChoice=scanner.nextInt();
           	 switch(serviceChoice)
           	 {
           	   case 1:serviceThree.chequeDeposit(account);
           	          break;
           	   case 2:serviceThree.cashDeposit(account);
           	           break;
               case 3:serviceThree.displayBalance(account);
                       break;
           	 }
        	}
        }
        
	}
	
	public static void displayCustomer(Customer customer)
	{
      System.out.println("\r\n"
      		+ "*************************Customer-Account Details****************\r\n"
      		+ "CustomerId	CustomerName		AccountType		Balance\r\n"
      		+ "***************************************************************\r\n"
      		+ "");
     for(Account account:customer.getAccountList())
     {
      System.out.println(customer.getCustomerCode()+"  "+customer.getCustomerName()+"  "+account.getAccountType()+"  "+account.getBalance());
       for(Service service:account.getProduct().getServiceList())
       {
    	   System.out.print(service.getServiceName()+"  ");
       }
       System.out.println();
     }
	}
	
}

