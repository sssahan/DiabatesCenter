/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author sachithra sahan
 */
public class GraphCreater extends JFrame{
    public GraphCreater( String applicationTitle , String chartTitle,ArrayList<String> resultList,ArrayList<String> dateList){
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
        chartTitle,
        "Testing date","Sugar level - units(mg/dL)",
        createDataset(resultList,dateList),
        PlotOrientation.VERTICAL,
        true,true,false);
       
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
        final CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
        CategoryAxis catAxis = plot.getDomainAxis();
        catAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
      
    }
    public static void createGraph(ArrayList<String> resultList,ArrayList<String> dateList,String testType){
        GraphCreater chart = new GraphCreater(
        "Sugar levels Vs testing dates" ,
        "last 10 "+testType+" level progress",resultList,dateList);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
        chart.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private DefaultCategoryDataset createDataset(ArrayList<String> resultList,ArrayList<String> dateList )
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
       for (int item = 0; item < resultList.size(); item++) {
           dataset.addValue(Integer.valueOf(resultList.get(item)), "Sugar level", dateList.get(item)+"  ");
       }
     
      return dataset;
   }
    
}
