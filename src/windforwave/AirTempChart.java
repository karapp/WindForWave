package windforwave;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

/**
 * Here we save a legend to a PNG file...the legend has a lot of items, so we
 * apply a width constraint so it doesn't get too wide.
 */
public class AirTempChart {

    /**
     * Entry point.
     *
     * @param args  command line arguments (ignored).
     *
     * @throws IOException if there is an input/output problem.
     */
    public static void main(String[] args) throws IOException {


        int i = 0;
        String aLine, aCount;
        WeatherData windData;
        XYSeries medelvind72 = new XYSeries("medelvind 74h");
        XYSeries medelvind48 = new XYSeries("medelvind 48h");
        
        //Öppnar ström och fil.
        FileReader reader = new FileReader("C:/vader/EasyWeather.dat");
        BufferedReader in = new BufferedReader(reader);

        //Läser in första raden.
        aLine = in.readLine();

        //Lägger in raden som objekt.
        windData = new WeatherData(aLine);

        //Kollar antalet rader i filen.
        int length = windData.getLength();


        //Flyttar markören till en tidigare rad..
        int sjutva = length - 144;
        int fyraatta = length - 96;
        double tid1 = -72;
        double tid2 = -48;
        while(aLine != null){
            aLine = in.readLine();
          

            i++;
            //Skickar den sista raden till objektet och skriv data till txt.
            if (sjutva < i && aLine != null) {

                 windData = new WeatherData(aLine);
                 System.out.println("72");
                medelvind72.add(tid1,windData.getOutdoorTempAsDouble());
                tid1 = tid1 + 0.5;
            }//Slut if

            if (fyraatta < i && aLine != null) {

                 windData = new WeatherData(aLine);
                 System.out.println("48");
                medelvind48.add(tid2,windData.getOutdoorTempAsDouble());
                tid2 = tid2 + 0.5;
            }//Slut if


            //System.out.println(i);
    
           
        }//Slut while


        XYSeriesCollection dataset72 = new XYSeriesCollection();
        XYSeriesCollection dataset48 = new XYSeriesCollection();
        dataset72.addSeries(medelvind72);
        dataset48.addSeries(medelvind48);

        //Här skapas 72h grafen och här kan inställningarna ändras.
        JFreeChart chart = ChartFactory.createXYLineChart(
        "Vindhastighet", // chart title
        "Tid", // x axis label
        "meter/sekund", // y axis label
        dataset72, // data
        PlotOrientation.VERTICAL,
        true, // include legend
        true, // tooltips
        false // urls
        );

        chart.setBackgroundPaint(Color.white);

        // färger på linjer m.m
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.lightGray);
        

        BufferedImage img2 = new BufferedImage(500, 250,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g22 = img2.createGraphics();
        chart.draw(g22, new Rectangle2D.Double(0, 0, 500, 250));
        g22.dispose();

        // ...and save it to a PNG image
        OutputStream out = new BufferedOutputStream(new FileOutputStream(
                new File("C:/vader/test/test.png")));
        ChartUtilities.writeBufferedImageAsPNG(out, img2);
        out.close();
        //-------------------------------------------------------------------

        JFreeChart chart1 = ChartFactory.createXYLineChart(
        "Vindhastighet", // chart title
        "Tid", // x axis label
        "meter/sekund", // y axis label
        dataset48, // data
        PlotOrientation.VERTICAL,
        true, // include legend
        true, // tooltips
        false // urls
        );

        chart1.setBackgroundPaint(Color.white);

        // färger på linjer m.m
        XYPlot plot1 = (XYPlot) chart1.getPlot();
        plot1.setBackgroundPaint(Color.white);
        plot1.setDomainGridlinePaint(Color.lightGray);
        plot1.setRangeGridlinePaint(Color.lightGray);


        BufferedImage img1 = new BufferedImage(500, 250,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g1 = img1.createGraphics();
        chart1.draw(g1, new Rectangle2D.Double(0, 0, 500, 250));
        g1.dispose();

        // ...and save it to a PNG image
        OutputStream out1 = new BufferedOutputStream(new FileOutputStream(
                new File("C:/vader/test/test1.png")));
        ChartUtilities.writeBufferedImageAsPNG(out1, img1);
        out1.close();

















    }
}
