package com.iavl.modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Modelo {

	@SuppressWarnings({ "resource", "unused" })
	public Modelo() {
		
		double f = 900, Hm = 1.5, Hb = 30,d=0; 
		@SuppressWarnings("unused")
		Scanner Scan = new Scanner(System.in);
		DecimalFormat dF = new DecimalFormat("#.0");
		dF.setMaximumFractionDigits(2);
		
        ArrayList<Double> LuArray = new ArrayList<Double>();
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		ArrayList<Double> LoArray = new ArrayList<Double>();	

	//	System.out.println("Frequency of Transmission in megahertz(MHz): ");
			//f = Scan.nextDouble();

	//	System.out.println("Height of base station antena in meters (m): ");
			//Hb = Scan.nextDouble();

	//	System.out.println("Height of mobile station antena in meters (m): ");
			//Hm = Scan.nextDouble();			 
		
	//	OkumuraHata Inst1 =  new OkumuraHata(f,Hm,Hb,d);

	//	LuArray = Inst1.OkumuraHataModel();
	//	LsuArray = Inst1.OkumuraHataSubUrban(LuArray);
	//	LoArray = Inst1.OkumuraHataOpen(LuArray);
		
	//	System.out.println(" Urban		 Sub Urban		 Open		");
	
//		for (int i = 0; i < LuArray.size(); i++) {
//			System.out.println("-"+dF.format(LuArray.get(i))+"		 -"+dF.format(LsuArray.get(i))+"		 -"+dF.format(LoArray.get(i)));
//		}
       
	}
}
