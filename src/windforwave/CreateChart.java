package windforwave;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Martin
 */
public class CreateChart {

    public void createChart(String title, String xLabel, String yLabel,
        XYSeriesCollection dataset, String location) throws IOException, FileNotFoundException {

        //Creates the chart.
        JFreeChart chart = ChartFactory.createXYLineChart(
        title, // chart title
        xLabel, // x axis label
        yLabel, // y axis label
        dataset, // data
        PlotOrientation.VERTICAL,
        true, // include legend
        true, // tooltips
        false // urls
        );

        //Colorization
        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.lightGray);

        //Creates the buffered img.
        BufferedImage img = new BufferedImage
                        (500, 250,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g22 = img.createGraphics();
        chart.draw(g22, new Rectangle2D.Double(0, 0, 500, 250));
        g22.dispose();

        //Saves the chart to a PNG image file.
        OutputStream out = new BufferedOutputStream(new FileOutputStream(
                new File(location)));
        ChartUtilities.writeBufferedImageAsPNG(out, img);
        out.close();
    }//End of createChart
}//End of CreateChart
