package ch.fhnw.vesys.currency;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;

/**
 * Created by benjamin on 17.03.2015.
 */
public class CurrencyConverter {

    public static void main(String[] args) {
        CurrencyConvertor service = new CurrencyConvertor();
        CurrencyConvertorSoap port = service.getCurrencyConvertorSoap();

        double result = port.conversionRate(Currency.EUR, Currency.CHF);
        System.out.println(result);
    }


}
