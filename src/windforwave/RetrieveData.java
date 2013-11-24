package windforwave;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This program retrieves the last, also the latest, data entry of the .dat
 * and writes some of the values to a .txt.
 * @author Martin
 */
public class RetrieveData {
	public static void main(String []arg) throws IOException {

        //Declaration and initiation of the variables.
        int i = 0;
        String aLine;
        WeatherData windData;

        //The .txt files is created and streams are established.
        PrintWriter wind = new PrintWriter (new BufferedWriter
                            (new FileWriter ("C:/vader/wind.txt")));

        PrintWriter gust = new PrintWriter (new BufferedWriter
                            (new FileWriter ("C:/vader/gust.txt")));

        PrintWriter direction = new PrintWriter (new BufferedWriter
                            (new FileWriter ("C:/vader/direction.txt")));

        PrintWriter outdoorTemp = new PrintWriter (new BufferedWriter
                            (new FileWriter ("C:/vader/outdoorTemp.txt")));

        PrintWriter timeRecorded = new PrintWriter (new BufferedWriter
                            (new FileWriter ("C:/vader/timeRecorded.txt")));

        //Open a stream to the .dat file.
        FileReader reader = new FileReader("C:/vader/EasyWeather.dat");
        BufferedReader in = new BufferedReader(reader);

        //Reads the first line and writes it to the object.
        aLine = in.readLine();
        windData = new WeatherData(aLine);

        //count the lines i the .dat file.
        int length = windData.getLength();


        //Moves the marker to the last line.
        length = length - 1;
        while(aLine != null){
            aLine = in.readLine();
            i++;
            
            //Sends the last line to the object.
            if (length == i) {
                System.out.println("sista raden");
                System.out.println(aLine);
                windData = new WeatherData(aLine);

                //Writes the values to the .txt files.
                wind.println(windData.getWind());
                wind.close();

                outdoorTemp.println(windData.getOutdoorTemp());
                outdoorTemp.close();

                gust.println(windData.getGust());
                gust.close();

                direction.println(windData.getDirectionText());
                direction.close();

                timeRecorded.println(windData.getTimeRecorded());
                timeRecorded.close();
            }//End if

        }//End while
	}//End main
}//End RetrieveData