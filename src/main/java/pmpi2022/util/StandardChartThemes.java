package pmpi2022.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.ui.RectangleInsets;

public class StandardChartThemes {

    public static void applyBarTheme(JFreeChart chart, Color titleColor) {
        applyBasicTheme(chart, titleColor);
        chart.getCategoryPlot().getRangeAxis().setAxisLineVisible(false);
        chart.getCategoryPlot().getRangeAxis().setTickMarksVisible(false);
        chart.getCategoryPlot().setRangeGridlineStroke(new BasicStroke());
        chart.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.decode("#666666"));
        chart.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.decode("#666666"));
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.decode("#4572a7"));
        BarRenderer rend = (BarRenderer) chart.getCategoryPlot().getRenderer();
        rend.setShadowVisible(true);
        rend.setShadowXOffset(2);
        rend.setShadowYOffset(0);
        rend.setShadowPaint(Color.decode("#C0C0C0"));
        rend.setMaximumBarWidth(0.1);
    }

    public static void applyRingChartTheme(JFreeChart chart, Color titleColor) {
        applyBasicTheme(chart, titleColor);
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);
        final PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{2}",
                NumberFormat.getIntegerInstance(), percentFormat);

        RingPlot plot = (RingPlot) chart.getPlot();

        plot.setLabelGenerator(labelGenerator);
        plot.setLabelLinkStyle(PieLabelLinkStyle.QUAD_CURVE);
        plot.setLabelOutlinePaint(Color.black);
        plot.setLabelShadowPaint(Color.decode("#C0C0C0"));
        plot.setLabelOutlineStroke(new BasicStroke());
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setSectionDepth(0.35d);
    }

    private static void applyBasicTheme(JFreeChart chart, Color titleColor) {
        String fontName = "ARIAL";
        StandardChartTheme theme = (StandardChartTheme) StandardChartTheme.createJFreeTheme();
        if(titleColor == null){
            theme.setTitlePaint(Color.decode("#4572a7"));
        }else{
            theme.setTitlePaint(titleColor);
        } 
        theme.setExtraLargeFont(new Font(fontName, Font.BOLD, 24)); //title
        theme.setLargeFont(new Font(fontName, Font.BOLD, 15)); //axis-title
        theme.setRegularFont(new Font(fontName, Font.PLAIN, 11));
        theme.setRangeGridlinePaint(Color.decode("#C0C0C0"));
        theme.setPlotBackgroundPaint(Color.white);
        theme.setChartBackgroundPaint(Color.white);
        theme.setGridBandPaint(Color.red);
        theme.setAxisOffset(new RectangleInsets(0, 0, 0, 0));
        theme.setBarPainter(new StandardBarPainter());
        theme.setAxisLabelPaint(Color.decode("#666666"));
        theme.apply(chart);
        chart.setTextAntiAlias(true);
        chart.setAntiAlias(true);
        chart.getPlot().setOutlineVisible(false);
    }
}
