package by.it.Utils;

import javax.swing.JFrame;

import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XYSeries series = new XYSeries("sin(a)");

        Double[] mass=new Double[20];
        for (int i =0;i<mass.length;i++)
            mass[i]=i+5.0;

        for(int i = 0; i < mass.length; i++){
            series.add(i, mass[i]);
            System.out.print(mass[i]+" ");
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = sin(x)", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        final ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
        final File file=new File("Chart.png");
        try {
            ChartUtilities.saveChartAsPNG(file,chart,600,400,info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setSize(400,300);
        frame.show();
    }
}
