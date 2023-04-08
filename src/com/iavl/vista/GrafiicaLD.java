package com.iavl.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class GrafiicaLD extends JPanel {
	

	public static ArrayList<Double> LuArray = new ArrayList<Double>();
	public static ArrayList<Double> LsuArray = new ArrayList<Double>();
	public static ArrayList<Double> LoArray = new ArrayList<Double>();
	public static ArrayList<String> EjeX = new ArrayList<String>();
	public static String titulo;	
	public static String ejeX;	
	public static String ejeY;	
	private static final long serialVersionUID = 1L;
	
	public GrafiicaLD(String Titulo,String ejeX,String ejeY, ArrayList<Double> LuArray, ArrayList<Double> LsuArray, ArrayList<Double> LoArray, ArrayList<String> EjeX) {
		super();
		GrafiicaLD.LuArray = LuArray;
		GrafiicaLD.LsuArray = LsuArray;
		GrafiicaLD.LoArray = LoArray;
		GrafiicaLD.titulo = Titulo;
		GrafiicaLD.ejeX = ejeX;
		GrafiicaLD.ejeY = ejeY;
		GrafiicaLD.EjeX = EjeX;
		JPanel content = createDemoPanel();
		add(content);

	}

	@SuppressWarnings("deprecation")
	public static JPanel createDemoPanel() {

		JFreeChart chart = ChartFactory.createLineChart(
				titulo,
				ejeX,
				ejeY,
				createDataset(),
				PlotOrientation.VERTICAL,
				true, true, false);

	
		final Shape[] shapes = new Shape[3];
        int[] xpoints;
        int[] ypoints;

        // right-pointing triangle
        xpoints = new int[] {-3, 3, -3};
        ypoints = new int[] {-3, 0, 3};
        shapes[0] = new Polygon(xpoints, ypoints, 3);

        // vertical rectangle
        shapes[1] = new Rectangle2D.Double(-2, -3, 3, 6);

        // left-pointing triangle
        xpoints = new int[] {-3, 3, 3};
        ypoints = new int[] {0, -3, 3};
        shapes[2] = new Polygon(xpoints, ypoints, 3);

        final DrawingSupplier supplier = new DefaultDrawingSupplier(
            DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
            shapes);
        
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setDrawingSupplier(supplier);
      
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.WHITE);
         
      //  plot.setDomainGridlinesVisible(true);
      //  plot.setDomainGridlinePaint(Color.WHITE);
       
        chart.setBackgroundPaint(Color.LIGHT_GRAY);

        // set the stroke for each series...
        plot.getRenderer().setSeriesStroke(
            0, 
            new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            )
        );
        plot.getRenderer().setSeriesStroke(
            1, 
            new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
            )
        );
        plot.getRenderer().setSeriesStroke(
            2, 
            new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
            )
        );

        // customise the renderer...
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setItemLabelsVisible(true);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(false);
        rangeAxis.setUpperMargin(0.12);

		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(640, 320));

		return chartPanel;
		
	}

	private static CategoryDataset createDataset() {
	
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		System.out.println("Hola Grafica");
		System.out.println(LuArray.size());
		System.out.println(LsuArray.size());
		System.out.println(LoArray.size());
		
		for(int i = 0; i < LoArray.size(); i++) {
		
			dataset.addValue(LuArray.get(i),"Urban", EjeX.get(i));
			dataset.addValue(LsuArray.get(i),"Sub Urban", EjeX.get(i));
			dataset.addValue(LoArray.get(i),"Rular", EjeX.get(i));
		}

		return dataset;
	}
	

}