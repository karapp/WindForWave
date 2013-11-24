package windforwave;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *  This program creates the different datasets that will support the creation
 *  of the charts that the class CreateChart will use.
 * @author Martin
 */
public class CreateDataset {

    public XYSeriesCollection createDataset (double scope, String name,
                        int type) throws IOException, FileNotFoundException  {

        //Declare variables
        String aLine;
        int i = 0;
        double length = 0;
        double time = 0;

        //Creates data series
        XYSeries serie = new XYSeries(name);
        XYSeries serie1 = new XYSeries("Maxvind");

        //Open the stream to the file.
        FileReader reader = new FileReader("C:/vader/EasyWeather.dat");
        BufferedReader in = new BufferedReader(reader);

        //Read the first line.
        aLine = in.readLine();

        //Insert the first line to an object.
        WeatherData windData = new WeatherData(aLine);

        //Check how many lines the file contains.
        length = windData.getLength();

        //Moves the mark to the right position
        length = length - scope;

        //Make the scope to a negative value.
        String scopeTxt = Double.toString(scope);
        scope = Double.parseDouble("-" + scopeTxt);

        time = scope/2;

        //Reads a line until it's not null.
        while(aLine != null){
            aLine = in.readLine();
            i++;

            //Sends data to the object until the length is the same as i or 
            //aLine is null.
            if (length < i && aLine != null) {
                
                //Send data to the object.
                windData = new WeatherData(aLine);

                //Inserts the temperature to a serie.
                if (type == 1) {
                    serie.add(time,windData.getOutdoorTempAsDouble());
                }

                //Insert gust and wind to series.
                if (type == 2){
                    serie.add(time, windData.getWindAsDouble());
                    serie1.add(time,windData.getGustAsDouble());
                }

                //Inserts the gust to a serie.
                if (type == 3){
                    serie.add(time, windData.getGustAsDouble());
                }

                //Insert the numeric representation of the wind direction
                if (type == 4){
                    serie.add(time, windData.getDirectionNoAsDouble());
                }
                //Increses the time.
                time = time + 0.5;

            }//End of if

        }//End of while

        //Create the dataset
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Inserts the serie
        dataset.addSeries(serie);

        //Inserts the second serie to the dataset.
        if (type==2)
            dataset.addSeries(serie1);

        return dataset;
    }
}
