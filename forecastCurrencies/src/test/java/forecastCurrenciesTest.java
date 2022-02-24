import currencies.Currency;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class forecastCurrenciesTest {
    @Test
    public void rightValue() throws IOException {
        Currency eur = new Currency();
        eur.getValuesFromCSV("D:\\JAVAPROKECTS\\forecastCurrencies\\src\\main\\resources\\EUR_F01_02_2002_T01_02_2022.csv");
        int value = (int)eur.forecastTomorrow();
        assertEquals(value,(int)eur.forecastTomorrow());
    }

}