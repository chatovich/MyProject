package by.it.Utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

/**
 * A demo showing how to create an HTML image map for a scatter plot.
 *
 */
/*public class ImageMapDemo7 {}

    /**
     * Default constructor.
     */
 /*   public ImageMapDemo7() {
        super();
    }

    /**
     * Starting point for the demo.
     *
     * @param args  ignored.
     */
 /*   public static void main(final String[] args) {

        final XYDataset data = new SampleXYDataset2();
        final JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter Plot Demo",
                "X", "Y",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
//        final Legend legend = chart.getLegend();
        //      if (legend instanceof StandardLegend) {
        //        final StandardLegend sl = (StandardLegend) legend;
        //      sl.setDisplaySeriesShapes(true);
        //}
        final NumberAxis domainAxis = (NumberAxis) chart.getXYPlot().getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);
        chart.setBackgroundPaint(java.awt.Color.white);

        // ****************************************************************************
        // * JFREECHART DEVELOPER GUIDE                                               *
        // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
        // * to purchase from Object Refinery Limited:                                *
        // *                                                                          *
        // * http://www.object-refinery.com/jfreechart/guide.html                     *
        // *                                                                          *
        // * Sales are used to provide funding for the JFreeChart project - please    *
        // * support us so that we can continue developing free software.             *
        // ****************************************************************************

        // save it to an image
        try {
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("scatter100.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

            // write an HTML page incorporating the image with an image map
            final File file2 = new File("scatter100.html");
            final OutputStream out = new BufferedOutputStream(new FileOutputStream(file2));
            final PrintWriter writer = new PrintWriter(out);
            writer.println("<HTML>");
            writer.println("<HEAD><TITLE>JFreeChart Image Map Demo</TITLE></HEAD>");
            writer.println("<BODY>");
//            ChartUtilities.writeImageMap(writer, "chart", info);
            writer.println("<IMG SRC=\"scatter100.png\" "
                    + "WIDTH=\"600\" HEIGHT=\"400\" BORDER=\"0\" USEMAP=\"#chart\">");
            writer.println("</BODY>");
            writer.println("</HTML>");
            writer.close();

        }
        catch (IOException e) {
            System.out.println(e.toString());
        }

    }

}*/

