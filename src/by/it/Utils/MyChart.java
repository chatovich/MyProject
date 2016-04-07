package by.it.Utils;

import by.it.generate.Building;
import by.it.generate.Room;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Объект получает здание и создает изображения для каждого его помещения
 * и может перегнать их в HTML
 */
public class MyChart {
    Building myBuilding;
    ArrayList<String> imageNames=new ArrayList<>();
    private ImageAdd imageAdd;

    public MyChart(Building build) throws FileNotFoundException {
        myBuilding=build;
    }

    public ImageAdd getImageAdd(){
        return imageAdd;
    }

    public void outputChart() throws Exception {
        imageAdd=new ImageAdd();

        int i=0;
        for (Room temp:myBuilding.getRoom()){
            createImage(createChart(createDataset(temp),temp),i);//создаем изображения для каждого помещения
            i++;
        }
    }

    private XYDataset createDataset(Room myRoom) {
        final XYSeries series1 = new XYSeries("Среднеобъемная температура");
        int i=0;
        for (Double temp:myRoom.getChangeInMeanBulkTemperature().getChanges()) {
            series1.add(i, temp);
            i++;
        }

        final XYSeries series2 = new XYSeries("Температура перекрытия");
        i=0;
        for (Double temp:myRoom.getChangeInTemperatureOfSlab().getChanges()) {
            series2.add(i, temp);
            i++;
        }

        final XYSeries series3 = new XYSeries("Температура вертикальных конструкций");
        i=0;
        for (Double temp:myRoom.getChangeInTemperatureOfWalls().getChanges()) {
            series3.add(i, temp);
            i++;
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }
    private JFreeChart createChart(final XYDataset dataset,Room myRoom) {
        char degree=176;//degree sign
        String title=myRoom.getCommonParameters().getNameOfRoom();
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

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);

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
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
        );
        plot.getRenderer().setSeriesStroke(
                1,
                new BasicStroke(
                        1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                        1.0f, new float[] {10.0f, 6.0f}, 0.0f
                )
        );
        plot.getRenderer().setSeriesStroke(
                2,
                new BasicStroke(
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                        1.0f, new float[] {1.0f, 6.0f}, 0.0f
                )
        );
        renderer.setDrawSeriesLineAsPath(true);
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }

    public void chartToHTML() throws FileNotFoundException {

        String fileName="allCharts.html";
        final File file = new File("src/by/it/ProgramCreate/"+fileName);
        final OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        final PrintWriter writer = new PrintWriter(out);
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>Графики всех помещений</TITLE></HEAD>");
        writer.println("<BODY>");

        for (String temp: imageNames)
        writer.println("<IMG SRC=\""+temp+"\" "
                + "WIDTH=\"600\" HEIGHT=\"400\" BORDER=\"0\" USEMAP=\"#chart\">");

        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }

    private void createImage(JFreeChart chart, int i) throws Exception {
        final ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
        String fileName="Chart"+i+".png";
        String filepath="src/by/it/ProgramCreate/";
        imageNames.add(fileName);
        final File file=new File(filepath+fileName);
        ChartUtilities.saveChartAsPNG(file,chart,600,400,info);

        imageAdd.chartToReport(filepath+fileName);//заодно закидываем в список объектов для отчёта
    }
}
