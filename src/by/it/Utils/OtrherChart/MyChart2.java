package by.it.Utils.OtrherChart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import by.it.generate.Building;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by Admin on 30.03.2016.
 */
public class MyChart2 {
    Building myBuilding;
   // public MyChart(Building build) {
     //   myBuilding=build;
   // }
    ArrayList<String> imageNames=new ArrayList<String>();

    private XYDataset createDataset() {
        final XYSeries series1 = new XYSeries("Среднеобъемная температура");
        series1.add(1.0, 1.0);
        series1.add(1.0, 5.0);
        final XYSeries series2 = new XYSeries("Температура перекрытия");
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
    private JFreeChart createChart(final XYDataset dataset) {
        char degree=176;//degree sign
       // String title=myRoom.getCommonParameters().getName();
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "",                           // chart title
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
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        plot.getRenderer().setSeriesStroke(
                1,
                new BasicStroke(
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                        1.0f, new float[] {3.0f, 0.0f}, 2.0f
                )
        );
        plot.getRenderer().setSeriesStroke(
                2,
                new BasicStroke(
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                        1.0f, new float[] {1.0f, 15.0f}, 2.0f
                )
        );

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;
    }
    public void ChartToHTML() throws FileNotFoundException {
        // write an HTML page incorporating the image with an image map
        String fileName="allCharts.html";
        final File file2 = new File("src/by/it/ProgramCreate/"+fileName);
        final OutputStream out = new BufferedOutputStream(new FileOutputStream(file2));
        final PrintWriter writer = new PrintWriter(out);
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>Графики всех помещений</TITLE></HEAD>");
        writer.println("<BODY>");
        //    ChartUtilities.writeImageMap(writer, "chart", info);
        for (String temp: imageNames)
        writer.println("<IMG SRC=\""+temp+"\" "
                + "WIDTH=\"600\" HEIGHT=\"400\" BORDER=\"0\" USEMAP=\"#chart\">");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }
    public void CreateImage(MyChart2 demo, int i){
        final ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
        String fileName="Chart123"+i+".png";
        imageNames.add(fileName);
        final File file=new File("src/by/it/ProgramCreate/"+fileName);
        try {
            ChartUtilities.saveChartAsPNG(file,demo.createChart(demo.createDataset()),600,400,info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MyChart2 b=new MyChart2();
        b.CreateImage(b,1);
    }
}
