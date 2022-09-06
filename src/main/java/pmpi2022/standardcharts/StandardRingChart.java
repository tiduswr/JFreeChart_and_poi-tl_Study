package pmpi2022.standardcharts;

import java.awt.Color;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import pmpi2022.util.StandardChartThemes;

public final class StandardRingChart extends StandardChart<DefaultPieDataset, RingPlot>{    
    public StandardRingChart(String title, int width, int height, Color titleColor) {
        super(title, width, height, new DefaultPieDataset(), titleColor);
    }
    
    @Override
    protected void buildChart(){
        this.chart = ChartFactory.createRingChart(title, dataset, 
                true, true, Locale.getDefault());
        StandardChartThemes.applyRingChartTheme(this.chart, titleColor);
        seriesColor.forEach((k, p) -> configPlot().setSectionPaint(k, p));
    }
    
    public StandardRingChart setValue(Comparable key, Number n){
        this.getDataSet().setValue(key, n);
        return this;
    }
    
    public StandardRingChart setValue(Comparable key, double n){
        this.getDataSet().setValue(key, n);
        return this;
    }
    
    @Override
    public StandardRingChart setSerieColor(Comparable key, Color color){
        return (StandardRingChart) super.setSerieColor(key, color);
    }
    
}
