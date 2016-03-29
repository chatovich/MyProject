package by.it.Utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import by.it.generate.Building;
import by.it.generate.Room;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 * Created by Admin on 30.03.2016.
 */
public class MyChart {
    Building myBuilding;
    public MyChart(Building build) {
        myBuilding=build;
    }
    private XYDataset createDataset(Room myRoom) {

        final XYSeries series1 = new XYSeries("Среднеобъемная температура\n");
        series1.add(1.0, 1.0);
        series1.add(1.0, 5.0);
        final XYSeries series2 = new XYSeries("Температура перекрытия\n");
        series2.add(1.0, 5.0);
        series2.add(3.0, 4.0);
        final XYSeries series3 = new XYSeries("Температура вертикальных конструкций");
        series3.add(3.0, 4.0);
        series3.add(15.0, 2.0);
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }
    private JFreeChart createChart(final XYDataset dataset,Room myRoom) {
        char degree=176;//degree sign
        String title=myRoom.getCommonParameters().getName();
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                title,                           // chart title
                "Время, t, мин",                // x axis label
                "Температура, Т, С"+degree,     // y axis label
                dataset,                        // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
        //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);
        plot.setRenderer(renderer);
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

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;
    }
   /* public static void main(String[] args) {
        final MyChart demo = new MyChart();
        final ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
        final File file=new File("src/by/it/ProgramCreate/Chart.png");
        try {
            ChartUtilities.saveChartAsPNG(file,demo.createChart(demo.createDataset()),600,400,info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
