package com.ilp.utility;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;
import com.ilp.services.AvailableServices;

public class BankUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Service> serviceList=new ArrayList<Service>(); 
		ArrayList<Product> productList=new ArrayList<Product>();
		Customer customer=null;
		int serviceChoice=0;
		char mainMenu='y';
        Scanner scanner=new Scanner(System.in);
        do {
        System.out.println("******Welcome To Bank************\r\n");
        System.out.println("1.Create Service\r\n"
        		+ "2.Create Product\r\n"
        		+ "3.Create Customer\r\n"
        		+ "4.Manage Accounts\r\n"
        		+ "5.Display Customer\r\n"
        		+ "6.Exit\r\n"
        		+ "");
        System.out.println("Enter your choice: ");
        serviceChoice=scanner.nextInt();  
        switch(serviceChoice) {
        case 1:
        	AvailableServices.createService(serviceList);
        	System.out.println(serviceList);
        	break;
        case 2:
        	AvailableServices.createProduct(serviceList,productList);
        	System.out.println(productList);
        	break;
        case 3:
        	customer=AvailableServices.createCustomer(customer,productList);
        	System.out.println(customer);
        	break;
        case 4:
        	AvailableServices.manageAccounts(customer);
        	break;
        case 5:
        	AvailableServices.displayCustomer(customer);
        	break;
        case 6:
         	break;
    	
        }
	}while(mainMenu == 'y');
        System.out.println("Go back to main menu?(y/n): ");
        
	}

}
