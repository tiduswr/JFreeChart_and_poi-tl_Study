package pmpi2022.standardcharts;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import pmpi2022.util.StandardChartThemes;

public class StandardBarChart extends StandardChart<DefaultCategoryDataset, CategoryPlot>{
    private final PlotOrientation orientation;
    
    public StandardBarChart(String title, int width, int height, PlotOrientation orientation, Color titleColor) {
        super(title, width, height, new DefaultCategoryDataset(), titleColor);
        this.orientation = orientation;
    }
    
    @Override
    protected void buildChart(){
        this.chart = ChartFactory.createBarChart(title, null, null,
                dataset, orientation, true, true, false);
        StandardChartThemes.applyBarTheme(this.chart, titleColor);
        seriesColor.forEach((k, c) -> setSeriesColors(k, c));
    }
    
    public StandardBarChart addValue(Number n, Comparable rowKey, Comparable colKey){
        this.getDataSet().setValue(n, rowKey, colKey);
        return this;
    }
    
    public StandardBarChart addValue(double n, Comparable rowKey, Comparable colKey){
        this.getDataSet().setValue(n, rowKey, colKey);
        return this;
    }
    
    private void setSeriesColors(Comparable key, Color color){
        BarRenderer render = (BarRenderer) configPlot().getRenderer();
        int index = dataset.getRowIndex(key);
        if(index != -1) render.setSeriesPaint(index, color);
    }
    
    @Override
    public StandardBarChart setSerieColor(Comparable key, Color color){
        return (StandardBarChart) super.setSerieColor(key, color);
    }
    
}
