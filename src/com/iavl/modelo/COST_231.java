package com.iavl.modelo;

import java.util.ArrayList;

public class COST_231 {

	double f;
	double Cm;
	double Hm;
	double Hb;
	double d;
	double aHr;

	public COST_231(double f ,double Hm,double Hb,double d) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.Hm = Hm;
		this.Hb = Hb;
		this.d = d; 
	}

	public ArrayList<Double> COST_231Model() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		if(f >= 150 && f <= 200){
			LuArray = COST_231LargeLfUrban();
			return LuArray;
		}else if(f >= 200 && f <= 2000){
			LuArray = COST_231LargeHfUrban();
			return LuArray;
		}
		return LuArray;
	}	
	public ArrayList<Double> COST_231ModelHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		if(f >= 150 && f <= 200){
			LuArray = COST_231LargeLfUrbanHb();
			return LuArray;
		}else if(f >= 200 && f <= 2000){
			LuArray = COST_231LargeHfUrbanHb();
			return LuArray;
		}
		return LuArray;
	}	
	
	public ArrayList<Double> COST_231ModelF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		if(f >= 150 && f <= 200){
			LuArray = COST_231LargeLfUrbanF();
			return LuArray;
		}else if(f >= 200 && f <= 2000){
			LuArray = COST_231LargeHfUrbanF();
			return LuArray;
		}
		return LuArray;
	}	
	
	public ArrayList<Double> COST_231LargeLfUrban() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3;
	    this.aHr = 8.29*Math.pow((Math.log10(1.54*Hm)),2)-1.1;
			System.out.println("Antena heigh correction factor: "+Cm);

			for(int d = 1; d < 20; d++) {
		        LuArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}

		return LuArray;
	}
	
	public ArrayList<Double> COST_231LargeHfUrban() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3;
	    this.aHr = 3.2*Math.pow((Math.log10(11.75*Hm)),2)-4.97;
	    
			System.out.println("Antena heigh correction factor: "+Cm);

			for(int d=1; d < 20; d++) {
		        LuArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}

		return LuArray;
	}
	
	public ArrayList<Double> COST_231SubUrban() {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		    this.Cm = 0;
		    this.aHr = ((1.1 * Math.log10(f)-0.7)*Hm) - (1.56 * Math.log10(f)-0.8);

			for(int d=1; d < 20; d++) {
		        LsuArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> COST_231Open() {
		ArrayList<Double> LoArray = new ArrayList<Double>();
		this.Cm = 0;
		this.aHr = ((1.1 * Math.log10(f)-0.7)*Hm) - (1.56 * Math.log10(f)-0.8);

			for(int d=1; d < 20; d++) {
		        LoArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}
			
	return LoArray;
	}
	
	public ArrayList<Double> COST_231LargeLfUrbanHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3;
	    this.aHr = 8.29*Math.pow((Math.log10(1.54*Hm)),2)-1.1;
			System.out.println("Antena heigh correction factor: "+Cm);

			for(int i =30; i < 200; i++) {
		        LuArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(i)) - (aHr) + (44.9 - 6.55*(Math.log10(i)))*Math.log10(d)+Cm);
			}

		return LuArray;
	}
	
	public ArrayList<Double> COST_231LargeHfUrbanHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3;
	    this.aHr = 3.2*Math.pow((Math.log10(11.75*Hm)),2)-4.97;
	    
			System.out.println("Antena heigh correction factor: "+Cm);

			for(int i =30; i < 200; i++) {
		        LuArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(i)) - (aHr) + (44.9 - 6.55*(Math.log10(i)))*Math.log10(d)+Cm);
			}

		return LuArray;
	}
	
	public ArrayList<Double> COST_231SubUrbanHb() {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		    this.Cm = 0;
		    this.aHr = ((1.1 * Math.log10(f)-0.7)*Hm) - (1.56 * Math.log10(f)-0.8);

			for(int i =30; i < 200; i++) {
		        LsuArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(i)) - (aHr) + (44.9 - 6.55*(Math.log10(i)))*Math.log10(d)+Cm);
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> COST_231OpenHb() {
		ArrayList<Double> LoArray = new ArrayList<Double>();
		this.Cm = 0;
		this.aHr = ((1.1 * Math.log10(f)-0.7)*Hm) - (1.56 * Math.log10(f)-0.8);

		for(int i =30; i < 200; i++) {
		        LoArray.add(46.3 + (33.9*(Math.log10(f))) - (13.82*Math.log10(i)) - (aHr) + (44.9 - 6.55*(Math.log10(i)))*Math.log10(d)+Cm);
			}
			
	return LoArray;
	}
	
	
	
	
	public ArrayList<Double> COST_231LargeLfUrbanF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3;
	    this.aHr = 8.29*Math.pow((Math.log10(1.54*Hm)),2)-1.1;

			for(int i =800; i < 2000; i++) {
		        LuArray.add(46.3 + (33.9*(Math.log10(i))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}

		return LuArray;
	}
	
	public ArrayList<Double> COST_231LargeHfUrbanF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		
		this.Cm = 3;
	    this.aHr = 3.2*Math.pow((Math.log10(11.75*Hm)),2)-4.97;
	    

	    	for(int i =800; i < 2000; i++) {
		        LuArray.add(46.3 + (33.9*(Math.log10(i))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}

		return LuArray;
	}
	
	public ArrayList<Double> COST_231SubUrbanF() {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		    this.Cm = 0;

			for(int i =800; i < 2000; i++) {
			    this.aHr = ((1.1 * Math.log10(i)-0.7)*Hm) - (1.56 * Math.log10(i)-0.8);
		        LsuArray.add(46.3 + (33.9*(Math.log10(i))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> COST_231OpenF() {
		ArrayList<Double> LoArray = new ArrayList<Double>();
		this.Cm = 0;

		for(int i =800; i < 2000; i++) {
				this.aHr = ((1.1 * Math.log10(i)-0.7)*Hm) - (1.56 * Math.log10(i)-0.8);
		        LoArray.add(46.3 + (33.9*(Math.log10(i))) - (13.82*Math.log10(Hb)) - (aHr) + (44.9 - 6.55*(Math.log10(Hb)))*Math.log10(d)+Cm);
			}
			
	return LoArray;
	}
}
