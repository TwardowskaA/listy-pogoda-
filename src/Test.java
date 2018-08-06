import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        File file = new File("cities.txt");
        ArrayList<String> miasta = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                miasta.add(scan.nextLine());
            }
            System.out.println(miasta);
            WeatherApi api = new WeatherApi();
            ArrayList<WeatherInfo> weather = new ArrayList<>();

            for (int i = 0; i < miasta.size(); i++) {
                String des = api.getDescription(miasta.get(i));
                System.out.println(des);
                Integer tem = api.getTemperature(miasta.get(i));
                System.out.println(tem);
                WeatherInfo wi = new WeatherInfo(miasta.get(i), des, tem);
                weather.add(wi);
            }
            System.out.println(weather);
            


//            FileWriter file1 = new FileWriter("cities.csv");
//            BufferedWriter bw = new BufferedWriter(file1);
//            for (int i = 0; i < miasta.size(); i++) {
//                bw = new WeatherInfo(miasta.get(i),api.getDescription(),api.getTemperature());
//
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
