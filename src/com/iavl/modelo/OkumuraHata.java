package com.iavl.modelo;

import java.util.ArrayList;

public class OkumuraHata {
	
	double f;
	double Cm;
	double Hm;
	double Hb;
	double d;

	public OkumuraHata(double f ,double Hm,double Hb,double d) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.Hm = Hm;
		this.Hb = Hb;
		this.d = d; 
	}

	public ArrayList<Double> OkumuraHataModel() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		if(Hm <= 10) {
			LuArray = OkumuraHataSmallMediumUrban();
			return LuArray;
		}else if(f >= 150 && f <= 200){
			LuArray = OkumuraHataLargeLfUrban();
			return LuArray;
		}else if(f >= 200 && f <= 1500){
			LuArray = OkumuraHataLargeHfUrban();
			return LuArray;
		}
		return LuArray;
	}	

	public ArrayList<Double> OkumuraHataModelHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		if(Hm <= 10) {
			LuArray = OkumuraHataSmallMediumUrbanHb();
			return LuArray;
		}else if(f >= 150 && f <= 200){
			LuArray = OkumuraHataLargeLfUrbanHb();
			return LuArray;
		}else if(f >= 200 && f <= 1500){
			LuArray = OkumuraHataLargeHfUrbanHb();
			return LuArray;
		}
		return LuArray;
	}		
	
	public ArrayList<Double> OkumuraHataModelF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		if(Hm <= 10) {
			LuArray = OkumuraHataSmallMediumUrbanF();
			return LuArray;
		}else if(f >= 150 && f <= 200){
			LuArray = OkumuraHataLargeLfUrbanF();
			return LuArray;
		}else if(f >= 200 && f <= 1500){
			LuArray = OkumuraHataLargeHfUrbanF();
			return LuArray;
		}
		return LuArray;
	}	
	
	public ArrayList<Double> OkumuraHataSmallMediumUrban() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 0.8 + ((1.1*Math.log10(f)-0.7)*(Hm)) - (1.56*Math.log10(900));
	        
			for(int d = 1; d < 20; d++) {
		        LuArray.add(69.55 + (26.16*(Math.log10(f))) - (13.82*Math.log10(Hb)) - (Cm) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d));
			}

		return LuArray;
	}	
	
	public ArrayList<Double> OkumuraHataLargeLfUrban() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 8.29*(Math.pow(Math.log10(1.54*Hm), 2)) - 1.1;
	        
			for(int d = 1; d < 20; d++) {
		        LuArray.add(69.55 + (26.16*(Math.log10(f))) - (13.82*Math.log10(Hb)) - (Cm) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d));
			}

		return LuArray;
	}
	
	public ArrayList<Double> OkumuraHataLargeHfUrban() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3.2*(Math.pow(Math.log10(11.75*Hm), 2)) - 4.97;
	        
			for(int d=1; d < 20; d++) {
		        LuArray.add(69.55 + (26.16*(Math.log10(f))) - (13.82*Math.log10(Hb)) - (Cm) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d));
			}

		return LuArray;
	}
	
	public ArrayList<Double> OkumuraHataSubUrban(ArrayList<Double> LuArray) {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		       
			for(int d = 0; d < LuArray.size(); d++) {
		        LsuArray.add(LuArray.get(d) - (2*(Math.pow(Math.log10(f/28), 2))) - 5.333);
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> OkumuraHataOpen(ArrayList<Double> LuArray) {
		ArrayList<Double> LoArray = new ArrayList<Double>();
	       
			for(int d = 0; d < LuArray.size(); d++) {
		        LoArray.add(LuArray.get(d) - (4.78*(Math.pow(Math.log10(f), 2))) + (18.33*Math.log10(f)) - 40.94);
			}
			
	return LoArray;
	}
	
	public ArrayList<Double> OkumuraHataSmallMediumUrbanHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 0.8 + ((1.1*Math.log10(f)-0.7)*(Hm)) - (1.56*Math.log10(900));
	        
			for(int i = 30; i < 200; i++) {
		        LuArray.add(69.55 + (26.16*(Math.log10(f))) - (13.82*Math.log10(i)) - (Cm) + (44.9 - 6.55*(Math.log10(i)))*Math.log10(d));
			}

		return LuArray;
	}	
	
	public ArrayList<Double> OkumuraHataLargeLfUrbanHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 8.29*(Math.pow(Math.log10(1.54*Hm), 2)) - 1.1;
	        
			System.out.println("Antena heigh correction factor: "+Cm);

			for(int i = 30; i < 200; i++) {
		        LuArray.add(69.55 + (26.16*(Math.log10(f))) - (13.82*Math.log10(i)) - (Cm) + (44.9 - 6.55*(Math.log10(i)))*Math.log10(d));
			}

		return LuArray;
	}
	
	public ArrayList<Double> OkumuraHataLargeHfUrbanHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3.2*(Math.pow(Math.log10(11.75*Hm), 2)) - 4.97;
	        
			System.out.println("Antena heigh correction factor: "+Cm);

			for(int i =30; i < 200; i++) {
		        LuArray.add(69.55 + (26.16*(Math.log10(f))) - (13.82*Math.log10(i)) - (Cm) + (44.9 - 6.55*(Math.log10(i)))*Math.log10(d));
			}

		return LuArray;
	}
	
	public ArrayList<Double> OkumuraHataSubUrbanHb(ArrayList<Double> LuArray) {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		int cont = 30;		       
			for(int i = 0; i < LuArray.size(); i++) {
		        LsuArray.add(LuArray.get(i) - (2*(Math.pow(Math.log10(cont/28), 2))) - 5.333);
		        cont++;
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> OkumuraHataOpenHb(ArrayList<Double> LuArray) {
		ArrayList<Double> LoArray = new ArrayList<Double>();
		int cont = 30;		       
			for(int i = 0; i < LuArray.size(); i++) {
		        LoArray.add(LuArray.get(i) - (4.78*(Math.pow(Math.log10(cont), 2))) + (18.33*Math.log10(cont)) - 40.94);
			}
			
	return LoArray;
	}
	
	
	
	public ArrayList<Double> OkumuraHataSmallMediumUrbanF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
			for(int i = 150; i < 1500; i++) {
				this.Cm = 0.8 + ((1.1*Math.log10(i)-0.7)*(Hm)) - (1.56*Math.log10(900));
		        LuArray.add(69.55 + (26.16*(Math.log10(i))) - (13.82*Math.log10(Hb)) - (Cm) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d));
			}

		return LuArray;
	}	
	
	public ArrayList<Double> OkumuraHataLargeLfUrbanF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		this.Cm = 8.29*(Math.pow(Math.log10(1.54*Hm), 2)) - 1.1;

			for(int i = 150; i < 1500; i++) {
				LuArray.add(69.55 + (26.16*(Math.log10(i))) - (13.82*Math.log10(Hb)) - (Cm) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d));
			}

		return LuArray;
	}
	
	public ArrayList<Double> OkumuraHataLargeHfUrbanF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		this.Cm = 3.2*(Math.pow(Math.log10(11.75*Hm), 2)) - 4.97;

			for(int i = 150; i < 1500; i++) {
				LuArray.add(69.55 + (26.16*(Math.log10(i))) - (13.82*Math.log10(Hb)) - (Cm) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d));
			}

		return LuArray;
	}
	
	public ArrayList<Double> OkumuraHataSubUrbanF(ArrayList<Double> LuArray) {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		int cont=150;       
			for(int i = 0; i < LuArray.size(); i++) {
		        LsuArray.add(LuArray.get(i) - (2*(Math.pow(Math.log10(cont/28), 2))) - 5.333);
		        cont++;
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> OkumuraHataOpenF(ArrayList<Double> LuArray) {
		ArrayList<Double> LoArray = new ArrayList<Double>();
		int cont=150;       
	       
			for(int i = 0; i < LuArray.size(); i++) {
		        LoArray.add(LuArray.get(i) - (4.78*(Math.pow(Math.log10(cont), 2))) + (18.33*Math.log10(cont)) - 40.94);
		        cont++;
			}
			
	return LoArray;
	}
}
