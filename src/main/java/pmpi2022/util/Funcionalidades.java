package pmpi2022.util;

import java.awt.Color;
import java.io.IOException;
import makeword.MakeWord;
import org.jfree.chart.plot.PlotOrientation;
import pmpi2022.standardcharts.StandardBarChart;
import pmpi2022.standardcharts.StandardRingChart;

public class Funcionalidades {
    public static void testar() throws IOException {
        //Criando grafico de Barras
        StandardBarChart barChart = new StandardBarChart("GRÁFICO DE BARRAS", 650, 400, PlotOrientation.VERTICAL, Color.BLACK);
        barChart.addValue(150, "2016", "MORTES")
            .addValue(130, "2016", "RENASCIMENTOS")
            .addValue(120, "2016", "NASCIMENTOS")
            .setSerieColor("2016", Color.yellow)
            .addValue(157, "2017", "MORTES")
            .addValue(145, "2017", "RENASCIMENTOS")
            .addValue(116, "2017", "NASCIMENTOS")
            .setSerieColor("2017", Color.PINK);
            
        //Criando grafico de Anel
        StandardRingChart pizza = new StandardRingChart("GRÁFICO PIZZA", 500, 400, null);
        pizza.setValue("HOMENS", 765)
            .setSerieColor("HOMENS", Color.BLUE)
            .setValue("MULHERES", 934)
            .setSerieColor("MULHERES", Color.PINK)
            .setValue("SEM RESPOSTA", 54)
            .setSerieColor("SEM RESPOSTA", Color.GRAY);
            
            
        //Criando arquivo word com graficos
        MakeWord doc = new MakeWord("model.docx");
        doc.replaceWithText("grafico1", "GRAFICO DE BARRAS - TESTE");
        doc.replaceWithPicture("histogram", pizza.buildAsBufferedImage());
        doc.replaceWithText("grafico2", "GRAFICO PIZZA - TESTE");
        doc.replaceWithPicture("pizza", barChart.buildAsBufferedImage());
        doc.applyModel("output.docx");
        
        //Salvando Graficos no formato de imagem
        pizza.exportChartAsPNG("pizza.png");
        barChart.exportChartAsPNG("barChart.png");
    }
}
