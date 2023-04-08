package com.iavl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.iavl.modelo.COST_231;
import com.iavl.modelo.Interim_Model;
import com.iavl.modelo.Modelo;
import com.iavl.modelo.OkumuraHata;
import com.iavl.vista.GrafiicaLD;
import com.iavl.vista.Vista;

public class Controlador implements ActionListener {

	// Instancia del frame principal
	Vista vista;
	Modelo modelo; // Instancia de clase 
    String newline = "\n";

    ArrayList<Double> LuArray = new ArrayList<Double>();
	ArrayList<Double> LsuArray = new ArrayList<Double>();
	ArrayList<Double> LoArray = new ArrayList<Double>();	
	
	public Controlador(Vista vista, Modelo modelo) {

		this.vista = vista;
		this.modelo = modelo;

		// Al boton que genera acci�n se debe asignar un addActionListener
		Vista.buttonUpload.addActionListener(this);

	}

	
	// Metodo que implementa ActionListener
	@SuppressWarnings({ "static-access", "unused" })
	public void actionPerformed(ActionEvent e) {
		double f=0, Hm=0, Hb=0, d=0; 
		int errorT = 0;
		String Titulo = "";
		String ejeX = "";
		String ejeY = "";
		String GrafType  = "";

		DecimalFormat dF = new DecimalFormat("#.0");
			dF.setMaximumFractionDigits(2);
        
		ArrayList<Double> LuArray = new ArrayList<Double>();
		ArrayList<Double> LsuArray = new ArrayList<Double>();
		ArrayList<Double> LoArray = new ArrayList<Double>();	
		ArrayList<String> LogArray = new ArrayList<String>();	
		ArrayList<String> EjeX = new ArrayList<String>();	

		if (e.getSource() == Vista.buttonUpload) {

			if (vista.radioButtonUrban.isSelected()) {
				Titulo = "Okumura Hata";
			} else if (vista.radioButtonSubUrban.isSelected()) {
				Titulo = "COST 231";
			} else if (vista.radioButtonOpen.isSelected()) {
				Titulo = "Stanford UI";
			}
			if (Titulo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error, eija una opcion para modelo" + JOptionPane.ERROR_MESSAGE);
				errorT++;
			}
			
			if (vista.radioButtonOpc1.isSelected()) {
				GrafType = "Loss v/s D";
			} else if (vista.radioButtonOpc2.isSelected()) {
				GrafType = "Loss v/s Hb";
			} else if (vista.radioButtonOpc3.isSelected()) {
				GrafType = "Loss v/s F";
			}
			if (GrafType.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Error, eija una opicion para graficar" + JOptionPane.ERROR_MESSAGE);
				errorT++;
			}

			
			//hiper = Boolean.parseBoolean(hiperTxt);
			//fum = Boolean.parseBoolean(fumTxt);
			//diab = Boolean.parseBoolean(diabTxt);
			//sexo = Boolean.parseBoolean(sexoTxt)};
			
			f = Double.parseDouble(vista.areaTextoFreq.getText());
			Hm = Double.parseDouble(vista.areaTextoHm.getText());
			Hb = Double.parseDouble(vista.areaTextoHb.getText());
			d = Double.parseDouble(vista.areaTextoDist.getText());

			OkumuraHata Inst1 =  new OkumuraHata(f,Hm,Hb,d);
			COST_231 Inst2 =  new COST_231(f,Hm,Hb,d);
			Interim_Model Inst3 =  new Interim_Model(f,Hm,Hb,d);

			
			
			//	Urban
			if(Titulo == "Urban") {
				
			}
			switch(Titulo){
				case "Okumura Hata":
					switch(GrafType){
						case "Loss v/s D":
							LuArray = Inst1.OkumuraHataModel();
							LsuArray = Inst1.OkumuraHataSubUrban(LuArray);
							LoArray = Inst1.OkumuraHataOpen(LuArray);
							ejeX = "Distance";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}
						break;
						case "Loss v/s Hb":
							LuArray = Inst1.OkumuraHataModelHb();
							LsuArray = Inst1.OkumuraHataSubUrbanHb(LuArray);
							LoArray = Inst1.OkumuraHataOpenHb(LuArray);
							ejeX = "Height Base Station";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}					
						break;
						case "Loss v/s F":
							LuArray = Inst1.OkumuraHataModelF();
							LsuArray = Inst1.OkumuraHataSubUrbanF(LuArray);
							LoArray = Inst1.OkumuraHataOpenF(LuArray);
							ejeX = "Frequency";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}					
						break;
					}
				break;
				case "COST 231":
					switch(GrafType){
						case "Loss v/s D":
							LuArray = Inst2.COST_231Model();
							LsuArray = Inst2.COST_231SubUrban();
							LoArray = Inst2.COST_231Open();
							ejeX = "Distance";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}								
						break;
						case "Loss v/s Hb":
							LuArray = Inst2.COST_231ModelHb();
							LsuArray = Inst2.COST_231SubUrbanHb();
							LoArray = Inst2.COST_231OpenHb();
							ejeX = "Distance";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}						
						break;
						case "Loss v/s F":
							LuArray = Inst2.COST_231ModelF();
							LsuArray = Inst2.COST_231SubUrbanF();
							LoArray = Inst2.COST_231OpenF();
							ejeX = "Frequency";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}					
						break;
					}					
				break;
				case "Stanford UI":
					switch(GrafType){
						case "Loss v/s D":
							LuArray = Inst3.Interim_ModelLargeUrban();
							LsuArray = Inst3.Interim_ModelSubUrban();
							LoArray = Inst3.Interim_ModelOpen();
							ejeX = "Distance";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}						
						break;
						case "Loss v/s Hb":
							LuArray = Inst3.Interim_ModelLargeUrbanHb();
							LsuArray = Inst3.Interim_ModelSubUrbanHb();
							LoArray = Inst3.Interim_ModelOpenHb();
							ejeX = "Distance";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}				
						break;
						case "Loss v/s F":
							LuArray = Inst3.Interim_ModelLargeUrban();
							LsuArray = Inst3.Interim_ModelSubUrban();
							LoArray = Inst3.Interim_ModelOpen();
							ejeX = "Frequency";
							ejeY = "Loss";
								for (int i = 0; i < LuArray.size(); i++) {
									EjeX.add(Integer.toString(i+1));
								}				
						break;
					}					
				break;
			}
			
			
			GrafiicaLD graficador = new GrafiicaLD(Titulo,ejeX,ejeY,LuArray,LsuArray,LoArray,EjeX);
			
			vista.graficaLd.removeAll();
			vista.graficaLd.add(graficador.createDemoPanel());
			vista.graficaLd.updateUI();
			
			vista.texto2.append("\n Urban		SubUrban		Open\n\n");

			for (int i = 0; i < LuArray.size(); i++) {
				vista.texto2.append("-"+dF.format(LuArray.get(i))+"		 -"+dF.format(LsuArray.get(i))+"		 -"+dF.format(LoArray.get(i))+"\n");
			}

		}

	}
	

}

