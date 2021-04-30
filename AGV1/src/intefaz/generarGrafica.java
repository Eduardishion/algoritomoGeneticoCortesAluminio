/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaz;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author DeveloperEdu
 */
public class generarGrafica extends ApplicationFrame{
    
    
    
    public generarGrafica(String title,float vector[]) {
        super(title);
        
         JFreeChart lineChart = ChartFactory.createLineChart(
         "Evolucion Individuos",
         "Years","Number of Schools",
         createDataset(vector),
         PlotOrientation.VERTICAL,
         true,true,false);
         
         
         
         ChartPanel chartPanel = new ChartPanel( lineChart );
         chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
         setContentPane( chartPanel );
        
    }
    
    private DefaultCategoryDataset createDataset(float[] vector)
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
       for (int i = 0; i < vector.length; i++) {
           dataset.addValue( (float)vector[i] , "individuos" ,""+(i+1)+"");
       }

      return dataset;
   }
    

}
