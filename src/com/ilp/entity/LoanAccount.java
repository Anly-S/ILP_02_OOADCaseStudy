package com.ilp.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class LoanAccount extends Product{
    private double chequeDeposit;
	public double getChequeDeposit() {
		return chequeDeposit;
	}
	public void setChequeDeposit(double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}
	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		this.chequeDeposit=0.03;
		// TODO Auto-generated constructor stub
	}
}
