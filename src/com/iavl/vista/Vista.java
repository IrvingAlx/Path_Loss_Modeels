package com.iavl.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.*;


public class Vista extends JFrame {

	public static ArrayList<Double> LuArray = new ArrayList<Double>();
	public static ArrayList<Double> LsuArray = new ArrayList<Double>();
	public static ArrayList<Double> LoArray = new ArrayList<Double>();
	public static ArrayList<String> EjeX = new ArrayList<String>();

	public GrafiicaLD graficaLd;
	public TextArea textArea;
	public static JButton buttonUpload;
	public static JButton buttonSave;
	public static JTextField areaTextoFreq;
	public static JTextField areaTextoHb;
	public static JTextField areaTextoHm;
	public static JTextField areaTextoDist;
	public static ButtonGroup buttonGroupType;
	public static JRadioButton radioButtonUrban;
	public static JRadioButton radioButtonSubUrban;
	public static JRadioButton radioButtonOpen;
	public static ButtonGroup buttonGroupOption;
	public static JRadioButton radioButtonOpc1;
	public static JRadioButton radioButtonOpc2;
	public static JRadioButton radioButtonOpc3;	
	public static JTextArea texto2;

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public Vista() {
		super("Path Loss Models");

		setLayout(new BorderLayout(50,50));
		setSize(1880,980);
		//setLocation(18, 18);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		graficaLd = new GrafiicaLD("Modelos","EjeX","EjeY", LuArray, LsuArray, LoArray, EjeX);
			graficaLd.setVisible(true);

		Image icon = Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\jhons\\Desktop\\antena-parabolica.png");

		setIconImage(icon);
		setResizable(false);

		JPanel pTotal = new JPanel();
			pTotal.setLayout(new GridLayout(1,2,70,70));
		JPanel pIzq = new JPanel();		//800px ancho
			pIzq.setLayout(null);
		JPanel pDer = new JPanel();
			pDer.setLayout(new GridLayout(2, 0));

		JPanel pDerImg = new JPanel();
			pDerImg.setLayout(new BorderLayout(50,50));			
			
		JLabel lableTop = new JLabel("Electromagnetic Wave Spread", SwingConstants.CENTER);
			lableTop.setFont(new Font("Abel_Regular", Font.BOLD, 60));
			
		JLabel lableBut = new JLabel("Irving Alejandro Vega Lagunas", SwingConstants.CENTER);
			lableBut.setFont(new Font("Abel_Regular", Font.BOLD, 30));

		JLabel lableL = new JLabel("L", SwingConstants.CENTER);
			lableL.setFont(new Font("Abel_Regular", Font.BOLD, 30));
			lableL.setForeground(Color.WHITE);		
		
		JLabel lableR = new JLabel("R", SwingConstants.CENTER);
			lableR.setFont(new Font("Abel_Regular", Font.BOLD, 30));
			lableR.setForeground(Color.WHITE);

		JLabel lableTop2 = new JLabel("T", SwingConstants.CENTER);
			lableTop2.setForeground(Color.WHITE);
			
		JLabel lableBut2 = new JLabel("B", SwingConstants.CENTER);
			lableBut2.setForeground(Color.WHITE);
			
		JLabel lableL2 = new JLabel("LAAAAAAAAAAAAAAAAAAA", SwingConstants.CENTER);
			lableL2.setForeground(Color.WHITE);		
		
		JLabel lableR2 = new JLabel("RAAAAAAAAAAAAAAAAAAA", SwingConstants.CENTER);
			lableR2.setForeground(Color.WHITE);
			
			
		JLabel lable4 = new JLabel("Path Loss Models", SwingConstants.CENTER);
			lable4.setFont(new Font("Abel_Regular", Font.BOLD, 40));

		buttonUpload = new JButton("Calcular");
			buttonUpload.setBounds(100, 650, 250, 80);
			buttonUpload.setFont(new Font("Abel_Regular", Font.BOLD, 20));
			buttonUpload.setForeground(Color.WHITE);
			buttonUpload.setBackground(Color.DARK_GRAY);

		buttonSave = new JButton("Guardar");
			buttonSave.setBounds(500, 650, 250, 80);		
			buttonSave.setFont(new Font("Abel_Regular", Font.BOLD, 20));
			buttonSave.setForeground(Color.WHITE);
			buttonSave.setBackground(Color.DARK_GRAY);			
			
		JLabel lableFreq = new JLabel("Frequency of Transmission in megahertz (MHz)");
			lableFreq.setBounds(50, 200, 750, 40);
			lableFreq.setFont(new Font("Abel_Regular", Font.BOLD, 25));
			lableFreq.setBackground(new Color(240, 115, 130));		
			
		JTextArea especifi = new JTextArea("Okumura Hata\r\n"
				+ "Frequency: 150 – 1500 MHz\r\n"
				+ "Mobile station antenna height: 1 – 10 m\r\n"
				+ "Base station antenna height: 30 – 200 m\r\n"
				+ "Link distance: 1–20 km\r\n"
				+ "\r\n"
				+ ""
				+ "COST 231\r\n"
				+ "Frequency: 800 – 2000 MHz\r\n"
				+ "Mobile station antenna height: 1 – 10 m\r\n"
				+ "Base station antenna height: 30 – 200 m\r\n"
				+ "Link distance: 1–20 km\r\n"
				+ "\r\n"
				+ ""
				+ "SUI\r\n"
				+ "Frequency: 2.5 – 2.7 MHz\r\n"
				+ "Mobile station antenna height: 2 – 10 m\r\n"
				+ "Base station antenna height: 15 – 40 m\r\n"
				+ "Link distance: 1–20 km");
			especifi.setBounds(615, 245, 250, 270);
			especifi.setEditable(false);
			especifi.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12));
			especifi.setBackground(Color.WHITE);
			especifi.setForeground(Color.BLACK);			
		
		areaTextoFreq = new JTextField(4);

			areaTextoFreq.setDocument(new LimitJTextField(4));
			areaTextoFreq.setBounds(50, 250, 550, 40);
			areaTextoFreq.setForeground(Color.BLACK);
			areaTextoFreq.setFont(new Font("Abel_Regular", Font.ITALIC, 20));

		Border border4 = BorderFactory.createLineBorder(Color.DARK_GRAY);
			areaTextoFreq.setBorder(BorderFactory.createCompoundBorder(border4,
					BorderFactory.createEmptyBorder(2, 2, 2, 2)));

		JLabel lableHb = new JLabel("Height of base station antenna in meters (m)");
			lableHb.setBounds(50, 300, 750, 40);
			lableHb.setFont(new Font("Abel_Regular", Font.BOLD, 25));
			lableHb.setBackground(new Color(240, 115, 130));		
		
		areaTextoHb = new JTextField(4);

			areaTextoHb.setDocument(new LimitJTextField(4));
			areaTextoHb.setBounds(50, 350, 550, 40);
			areaTextoHb.setForeground(Color.BLACK);
			areaTextoHb.setFont(new Font("Abel_Regular", Font.ITALIC, 20));

		Border border5 = BorderFactory.createLineBorder(Color.DARK_GRAY);
			areaTextoHb.setBorder(BorderFactory.createCompoundBorder(border4,
					BorderFactory.createEmptyBorder(2, 2, 2, 2)));

		
		JLabel lableHm = new JLabel("Height of mobile station antenna in meters (m)");
			lableHm.setBounds(50, 400, 750, 40);
			lableHm.setFont(new Font("Abel_Regular", Font.BOLD, 25));
			lableHm.setBackground(new Color(240, 115, 130));		
			
		areaTextoHm = new JTextField(4);

			areaTextoHm.setDocument(new LimitJTextField(4));
			areaTextoHm.setBounds(50, 450, 550, 40);
			areaTextoHm.setForeground(Color.BLACK);
			areaTextoHm.setFont(new Font("Abel_Regular", Font.ITALIC, 20));

		Border border6 = BorderFactory.createLineBorder(Color.DARK_GRAY);
			areaTextoHm.setBorder(BorderFactory.createCompoundBorder(border4,
					BorderFactory.createEmptyBorder(2, 2, 2, 2)));

			
		JLabel lableDist = new JLabel("Distance between the base and mobile stations (km)");
			lableDist.setBounds(50, 500, 750, 40);
			lableDist.setFont(new Font("Abel_Regular", Font.BOLD, 25));
			lableDist.setBackground(new Color(240, 115, 130));		 

		areaTextoDist = new JTextField(5);

			areaTextoDist.setDocument(new LimitJTextField(3));
			areaTextoDist.setBounds(50, 550, 550, 40);
			areaTextoDist.setForeground(Color.BLACK);
			areaTextoDist.setFont(new Font("Abel_Regular", Font.ITALIC, 20));

		Border border7 = BorderFactory.createLineBorder(Color.DARK_GRAY);
			areaTextoDist.setBorder(BorderFactory.createCompoundBorder(border4,
					BorderFactory.createEmptyBorder(2, 2, 2, 2)));
			
		radioButtonUrban = new JRadioButton("Okumura Hata");

			radioButtonUrban.setBounds(100, 25, 350, 50);
			radioButtonUrban.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonUrban.setActionCommand("true");

		radioButtonSubUrban = new JRadioButton("COST 231");

			radioButtonSubUrban.setBounds(100, 75, 250, 50);
			radioButtonSubUrban.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonSubUrban.setActionCommand("false");

		radioButtonOpen = new JRadioButton("Stanford UI");

			radioButtonOpen.setBounds(100, 125, 250, 50);
			radioButtonOpen.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonOpen.setActionCommand("false");
			
		buttonGroupType = new ButtonGroup();

			buttonGroupType.add(radioButtonUrban);
			buttonGroupType.add(radioButtonSubUrban);
			buttonGroupType.add(radioButtonOpen);
		
		Border border1 = BorderFactory.createLineBorder(Color.DARK_GRAY);
		radioButtonOpen.setBorder(BorderFactory.createCompoundBorder(border1,
					BorderFactory.createEmptyBorder(4, 4, 4, 4)));	

		radioButtonOpc1 = new JRadioButton("Loss v/s D");
			radioButtonOpc1.setBounds(550, 25, 250, 50);
			radioButtonOpc1.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonOpc1.setActionCommand("true");

		radioButtonOpc2 = new JRadioButton("Loss v/s Hb");

			radioButtonOpc2.setBounds(550, 75, 250, 50);
			radioButtonOpc2.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonOpc2.setActionCommand("false");

		radioButtonOpc3 = new JRadioButton("Loss v/s F");

			radioButtonOpc3.setBounds(550, 125, 250, 50);
			radioButtonOpc3.setFont(new Font("Abel_Regular", Font.BOLD, 40));
			radioButtonOpc3.setActionCommand("false");
			
		buttonGroupOption = new ButtonGroup();

			buttonGroupOption.add(radioButtonOpc1);
			buttonGroupOption.add(radioButtonOpc2);
			buttonGroupOption.add(radioButtonOpc3);			

		JLabel JLabel3 = new JLabel();
			JLabel3.setIcon(new ImageIcon("C:\\Users\\jhons\\Desktop\\img2.png"));
			
			// campo de texto JTextArea
		texto2 = new JTextArea(17,40);
			texto2.setEditable(false);
			texto2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
			texto2.setBackground(new Color(60,60,60));
			texto2.setForeground(new Color(240,240,240));
			
		JScrollPane pScroll = new JScrollPane(texto2, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
			
		pDerImg.add(lableTop2, BorderLayout.PAGE_START);
		pDerImg.add(lableL2, BorderLayout.LINE_START);
		pDerImg.add(JLabel3, BorderLayout.CENTER);
		pDerImg.add(lableBut2, BorderLayout.PAGE_END);
		pDerImg.add(lableR2, BorderLayout.LINE_END);			
		
		pIzq.add(radioButtonUrban);
		pIzq.add(radioButtonOpc1);
		pIzq.add(radioButtonSubUrban);
		pIzq.add(radioButtonOpc2);
		pIzq.add(radioButtonOpen);
		pIzq.add(radioButtonOpc3);
		
		pIzq.add(lableFreq);
		pIzq.add(especifi);
		pIzq.add(areaTextoFreq);
		pIzq.add(lableHb);
		pIzq.add(areaTextoHb);
		pIzq.add(lableHm);
		pIzq.add(areaTextoHm);
		pIzq.add(lableDist);
		pIzq.add(areaTextoDist);
		
		pIzq.add(buttonUpload);
		pIzq.add(buttonSave);		
		

		pDer.add(graficaLd);
		pDer.add(pScroll);
		
		pTotal.add(pIzq);
		pTotal.add(pDer);
		
		this.add(lableTop, BorderLayout.PAGE_START);
		this.add(lableL, BorderLayout.LINE_START);
		this.add(pTotal, BorderLayout.CENTER);
		this.add(lableBut, BorderLayout.PAGE_END);
		this.add(lableR, BorderLayout.LINE_END);
	}
	
	class LimitJTextField extends PlainDocument {

		private static final long serialVersionUID = 1L;
		private int max;

		LimitJTextField(int max) {
			super();
			this.max = max;
		}

		public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
			if (text == null)
				return;
			if ((getLength() + text.length()) <= max) {
				super.insertString(offset, text, attr);
			}
		}
	}

}
