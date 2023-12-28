package com.ilp.entity;
import java.util.ArrayList;
import java.util.Scanner;

public class SavingsMaxAccount extends Product{
   public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		this.minimumBalance=1000;
		// TODO Auto-generated constructor stub
	}

private double minimumBalance;

public double getMinimumBalance() {
	return minimumBalance;
}

public void setMinimumBalance(double minimumBalance) {
	this.minimumBalance = minimumBalance;
}

}