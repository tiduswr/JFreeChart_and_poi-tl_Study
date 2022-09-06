package pmpi2022.standardcharts;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

public class StandardChart<T, U> {
    protected T dataset;
    protected JFreeChart chart;
    protected final String title;
    protected final int width, height;
    protected final Color titleColor;
    protected final HashMap<Comparable, Color> seriesColor;
    
    public StandardChart(String title, int width, int height, T dataset, Color titleColor) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.dataset = dataset;
        this.titleColor = titleColor;
        seriesColor = new HashMap<>();
    }
    
    public BufferedImage buildAsBufferedImage(){
        buildChart();
        return (this.chart != null)  
            ? this.chart.createBufferedImage(width, height)
            : null;
    }
    
    public JFreeChart buildAsChart(){
        buildChart();
        return this.chart;
    }
    
    protected void buildChart(){
        this.chart = null;
    }
    
    public T getDataSet(){
        return this.dataset;
    }
    
    public U configPlot(){
        return (U) chart.getPlot();
    }
    
    public StandardChart setSerieColor(Comparable key, Color color){
        seriesColor.put(key, color);
        return this;
    }
    
    public void exportChartAsPNG(String fileOutputPath) throws IOException{
        ChartUtilities.saveChartAsPNG(new File(fileOutputPath), this.buildAsChart(), width, height);
    }
    
}
