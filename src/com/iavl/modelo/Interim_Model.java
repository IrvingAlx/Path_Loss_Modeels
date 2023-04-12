package com.iavl.modelo;

import java.util.ArrayList;

public class Interim_Model {
	double f, Cm, Hm, Hb, d, aHr, A;
	double d0 = 100;
	double y,Xf,Xh;

	public Interim_Model(double f ,double Hm,double Hb,double d) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.Hm = Hm;
		this.Hb = Hb;
		this.d = d; 
	}

	public ArrayList<Double> Interim_ModelLargeUrban() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
			this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/f*1000000));
			this.y = 4.6 + (0.0075*(Hb)) + (12.6/Hb);
		    this.Xf = 6*(Math.log10(f/2000));
		    this.Xh = -20*(Math.log10(Hm/2000));	    

			for(int d=1; d < 20; d++) {
		        LuArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 10.6));
			}

		return LuArray;
	}
	
	public ArrayList<Double> Interim_ModelSubUrban() {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		    this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/f*1000000));
		    this.y = 4 + (0.0065*(Hb)) + (17.1/Hb);
		    this.Xf = 6*(Math.log10(f/2000));
		    this.Xh = -20*(Math.log10(Hm/2000));
		    
			for(int d=1; d < 20; d++) {
		        LsuArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 9.6));
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> Interim_ModelOpen() {
		ArrayList<Double> LoArray = new ArrayList<Double>();
	    this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/f*1000000));
	    this.y = 3.6 + (0.005*(Hb)) + (20/Hb);
	    this.Xf = 6*(Math.log10(f/2000));
	    this.Xh = -20*(Math.log10(Hm/2000));

			for(int d=1; d < 20; d++) {
		        LoArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 8.2));
			}
			
	return LoArray;
	}
	
	public ArrayList<Double> Interim_ModelLargeUrbanHb() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
			this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/f*1000000));
		    this.Xf = 6*(Math.log10(f/2000));
		    this.Xh = -20*(Math.log10(Hm/2000));	    

	    	for(int i =15; i < 40; i++) {
				this.y = 4.6 + (0.0075*(i)) + (12.6/i); 
	    		LuArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 10.6)*-1);
			}

		return LuArray;
	}
	
	public ArrayList<Double> Interim_ModelSubUrbanHb() {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		    this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/f*1000000));
		    this.Xf = 6*(Math.log10(f/2000));
		    this.Xh = -20*(Math.log10(Hm/2000));
		    
	    	for(int i =15; i < 40; i++) {
			    this.y = 4 + (0.0065*(i)) + (17.1/i);
	    		LsuArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh - 9.6)*-1);
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> Interim_ModelOpenHb() {
		ArrayList<Double> LoArray = new ArrayList<Double>();
	    this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/f*1000000));
	    this.Xf = 6*(Math.log10(f/2000));
	    this.Xh = -20*(Math.log10(Hm/2000));

	    	for(int i =15; i < 40; i++) {
	    	    this.y = 3.6 + (0.005*(i)) + (20/i);
		        LoArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 8.2)*-1);
			}
			
	return LoArray;
	}

	public ArrayList<Double> Interim_ModelLargeUrbanF() {
		ArrayList<Double> LuArray = new ArrayList<Double>();
		    this.Xh = -20*(Math.log10(Hm/2000));	    
			this.y = 4.6 + (0.0075*(Hb)) + (12.6/Hb); 

	    	for(float i = (float)2.5; i < (float)2.7; i+=(float)0.01) {
				this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/i*1000000));
			    this.Xf = 6*(Math.log10(i/2000));
				LuArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 10.6)*-1);
			}

		return LuArray;
	}
	
	public ArrayList<Double> Interim_ModelSubUrbanF() {
		ArrayList<Double> LsuArray = new ArrayList<Double>();
	    	this.y = 4 + (0.0065*(Hb)) + (17.1/Hb);
		    this.Xh = -20*(Math.log10(Hm/2000));
		    
	    	for(float i = (float)2.5; i < (float)2.7; i+=(float)0.01) {
			    this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/i*1000000));
			    this.Xf = 6*(Math.log10(i/2000));
			    LsuArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 9.6)*-1);
			}
			
		return LsuArray;
	}
	
	public ArrayList<Double> Interim_ModelOpenF() {
		ArrayList<Double> LoArray = new ArrayList<Double>();
	    this.Xh = -20*(Math.log10(Hm/2000));
		this.y = 3.6 + (0.005*(Hb)) + (20/Hb);

			for(float i = (float)2.5; i < (float)2.7; i+=(float)0.01) {
	    	    this.A = 20*Math.log10(((4*Math.PI)*d0)/(299792458/i*1000000));
	    	    this.Xf = 6*(Math.log10(i/2000));
		        LoArray.add((A + ((10*y)*(Math.log10(d/d0))) + Xf + Xh + 8.2)*-1);
			}
			
	return LoArray;
	}
	
}
