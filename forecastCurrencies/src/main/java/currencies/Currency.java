package currencies;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Currency {

    private final List<Double> values = new ArrayList<>();
    String data = "";

    public List<Double> getValuesFromCSV(String pathFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            while ((data = br.readLine()) != null) {
                String[] arr = data.split("[;]");
                for (String s : arr) {
                    if (s.contains(",")) {
                        values.add(Double.valueOf(s.replace(',', '.')));
                    }
                }
            }
        }
        return values;
    }

    public List<Double> getValues() {
        return values;
    }

    public double forecastTomorrow(){
        double forecastTomorrow = 0;
        int i = 0;
        for (;i < 7;i++){
            forecastTomorrow += values.get(i);
        }
        forecastTomorrow/=7;
        values.add(0,forecastTomorrow);
        return values.get(0);
    }

    public double[] forecastTomorrowWeek(){
        double[] forecastTomorrowWeek = new double [7];
        forecastTomorrowWeek[0] = values.get(0);
        for(int i = 1;i < 7;i++){
            forecastTomorrowWeek[i] = forecastTomorrow();
        }
        return forecastTomorrowWeek;
    }

    public String getDateOfForeCast(int days){
        SimpleDateFormat formattedDate = new SimpleDateFormat("E dd.MM.yyyy - ");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, days);
        return (String)(formattedDate.format(c.getTime()));
    }
}
