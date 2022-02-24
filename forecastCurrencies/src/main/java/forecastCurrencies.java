import currencies.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class forecastCurrencies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Currency usd = new Currency();
        Currency eur = new Currency();
        Currency lira = new Currency();
        usd.getValuesFromCSV("D:\\JAVAPROKECTS\\forecastCurrencies\\src\\main\\resources\\USD_F01_02_2002_T01_02_2022.csv");
        eur.getValuesFromCSV("D:\\JAVAPROKECTS\\forecastCurrencies\\src\\main\\resources\\EUR_F01_02_2002_T01_02_2022.csv");
        lira.getValuesFromCSV("D:\\JAVAPROKECTS\\forecastCurrencies\\src\\main\\resources\\TRY_F01_02_2002_T01_02_2022.csv");

        System.out.println("Input 'START' to start forecasting");

        String consoleCommand = br.readLine();
        while (!(consoleCommand.equals("QUIT"))) {
            if ("START".equals(consoleCommand)) {
                System.out.println("""
                        Введите комманду "rate (TRY,USD,EUR - одну из них) tomorrow", для того чтобы узнать прогноз валюты на завтра.
                        Или "rate (TRY,USD,EUR - одну из них) week", чтобы узнать прогноз валют на неделю""");
                String command = br.readLine();
                switch (command) {
                    case "rate TRY tomorrow":
                        System.out.println(lira.getDateOfForeCast(1) + lira.forecastTomorrow()+"\n");
                        break;
                    case "rate TRY week":
                        for (int i = 0; i < 7; i++) {
                            System.out.println(lira.getDateOfForeCast(i + 1) + lira.forecastTomorrowWeek()[i] +"\n");
                        }
                        break;
                    case "rate USD tomorrow":
                        System.out.println(usd.getDateOfForeCast(1) + usd.forecastTomorrow() +"\n");
                        break;
                    case "rate USD week":
                        for (int i = 0; i < 7; i++) {
                            System.out.println(usd.getDateOfForeCast(i + 1) + usd.forecastTomorrowWeek()[i] +"\n");
                        }
                        break;
                    case "rate EUR tomorrow":
                        System.out.println(eur.getDateOfForeCast(1) + eur.forecastTomorrow() +"\n");
                        break;
                    case "rate EUR week":
                        for (int i = 0; i < 7; i++) {
                            System.out.println(eur.getDateOfForeCast(i + 1) + eur.forecastTomorrowWeek()[i] + "\n");
                        }
                        break;
                    default:
                        System.out.println("Неверная команда!");
                }
            }else {
                System.out.println("Неверная команда!");
            }
        }

    }

}
