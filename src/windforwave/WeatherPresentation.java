package windforwave;

import java.io.IOException;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * A program that will try to get a dataset and then make the dataset be drawn
 * as an PNG image that looks like a chart.
 * @author Martin
 */
public class WeatherPresentation {
    
    public static void main (String [] args) throws IOException {
        CreateDataset cd = new CreateDataset();
        CreateChart cc = new CreateChart();
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Creates the temperature datasets and graphs.
        dataset = cd.createDataset(144, "Lufttemperatur", 1);
        cc.createChart("Lufttemperatur", "Tid", "Celsius", dataset, "C:/vader/temp72.png");

        dataset = cd.createDataset(96, "Lufttemperatur", 1);
        cc.createChart("Lufttemperatur", "Tid", "Celsius", dataset, "C:/vader/temp48.png");

        dataset = cd.createDataset(48, "Lufttemperatur", 1);
        cc.createChart("Lufttemperatur", "Tid", "Celsius", dataset, "C:/vader/temp24.png");

        dataset = cd.createDataset(24, "Lufttemperatur", 1);
        cc.createChart("Lufttemperatur", "Tid", "Celsius", dataset, "C:/vader/temp12.png");

        //Creates the wind and gust datasets and graphs.
        dataset = cd.createDataset(144, "Medelvind", 2);
        cc.createChart("Vindhastighet i m/s", "Tid", "Styrka", dataset, "C:/vader/wind72.png");

        dataset = cd.createDataset(96, "Vindhastighet i m/s", 2);
        cc.createChart("Vindhastighet i m/s", "Tid", "Styrka", dataset, "C:/vader/wind48.png");

        dataset = cd.createDataset(48, "Vindhastighet i m/s", 2);
        cc.createChart("Vindhastighet i m/s", "Tid", "Styrka", dataset, "C:/vader/wind24.png");

        dataset = cd.createDataset(24, "Vindhastighet i m/s", 2);
        cc.createChart("Vindhastighet i m/s", "Tid", "Styrka", dataset, "C:/vader/wind12.png");

        //Creates the wind direction datasets and graphs.
        dataset = cd.createDataset(144, "Vindriktning", 4);
        cc.createChart("Vindriktning", "Tid", "Riktning", dataset, "C:/vader/direction72.png");

        dataset = cd.createDataset(96, "Vindriktning", 4);
        cc.createChart("Vindriktning", "Tid", "Riktning", dataset, "C:/vader/direction48.png");

        dataset = cd.createDataset(48, "Vindriktning", 4);
        cc.createChart("Vindriktning", "Tid", "Riktning", dataset, "C:/vader/direction24.png");

        dataset = cd.createDataset(24, "Vindriktning", 4);
        cc.createChart("Vindriktning", "Tid", "Riktning", dataset, "C:/vader/direction12.png");

    }//End of main

}//End WeatherPresentation
