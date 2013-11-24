package windforwave;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * This class represents a line in the file that contains the weather data.
 * @author Martin
 */
public class WeatherData {
    //Declaration of variables.
	private String position;
    private String propertiesdate;
    private String timeRecorded;
    private String interval;
    private String indoorHumdity;
    private String indoorTemp;
    private String outdoorHumidty;
    private String outdoorTemp;
    private String absoultePressure;
    private String wind;
    private String gust;
    private String directionText;
    private String relativePressure;
    private String dewpoint;
    private String windchill;
    private String windLevel;
    private String gustLevel;
    private String directionNo;

    //A constructor that scans the line for data.
	public WeatherData(String aLine)  {
        Scanner sc = new Scanner(aLine);
        sc.useDelimiter(",");
        position = sc.next();
        propertiesdate = sc.next();
        timeRecorded = sc.next();
        interval = sc.next();
        indoorHumdity = sc.next();
        indoorTemp = sc.next();
        outdoorHumidty = sc.next();
        outdoorTemp = sc.next();
        dewpoint = sc.next();
        windchill = sc.next();
        absoultePressure = sc.next();
        relativePressure = sc.next();
        wind = sc.next();
        windLevel = sc.next();
        gust = sc.next();
        gustLevel = sc.next();
        directionNo = sc.next();
        directionText = sc.next();        
    }
    
    //Get and set methods.
    public String getDirectionText() {
        return directionText;
    }

    public void setDirectionText(String direction) {
        this.directionText = direction;
    }

    public String getDirectionNo() {
        return directionNo;
    }

    public void setDirectionNo(String directionNo) {
        this.directionNo = directionNo;
    }

    public String getGust() {
        return gust;
    }

    public void setGust(String gust) {
        this.gust = gust;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getOutdoorTemp() {
        return outdoorTemp;
    }

    public void setOutdoorTemp(String outdoorTemp) {
        this.outdoorTemp = outdoorTemp;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPropertiesdate() {
        return propertiesdate;
    }

    public void setPropertiesdate(String propertiesdate) {
        this.propertiesdate = propertiesdate;
    }

    public String getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(String timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    //Get methods with correct data format.

    public double getGustAsDouble(){
        double gustDouble = Double.parseDouble(gust);
        return  gustDouble;
    }

    public double getOutdoorTempAsDouble(){
        double outdoorTempDouble = Double.parseDouble(outdoorTemp);
        return  outdoorTempDouble;
    }

    public double getWindAsDouble(){
        double windDouble = Double.parseDouble(wind);
        return  windDouble;
    }

    public double getDirectionNoAsDouble(){
        double directionDouble = Double.parseDouble(directionNo);
        return directionDouble;
    }

    /*
     * A method that counts how many lines ther is in the .dat-file.
     * @ return length The number of lines in the file.
     */
    public int getLength() throws IOException, FileNotFoundException{
        FileReader reader = new FileReader("C:/vader/EasyWeather.dat");
        BufferedReader in = new BufferedReader(reader);
        
        String aCount = in.readLine();
        int length = 0;
        while(aCount != null){
            aCount = in.readLine();
            length++;
        }
        in.close();

        return length;
    }
}

