package com.tugbacevizci.currency;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by Burakiren on 17/12/2015.
 */
public class CurrencyConverterValue extends BaseCurrencyConverter
{
    public float convert(String currencyFrom, String currencyTo) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s=" + currencyFrom + currencyTo + "=X&f=l1&e=.csv");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpGet, responseHandler);
        httpclient.getConnectionManager().shutdown();
        return Float.parseFloat(responseBody);
    }
    public void convert(CurrencyPair[] currencyPairs) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        StringBuffer sb = new StringBuffer();
        for (CurrencyPair currencyPair : currencyPairs) {
            sb.append("s=").append(currencyPair.getFrom()).append(currencyPair.getTo()).append("=X&");
        }
        HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?" + sb + "f=l1&e=.csv");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpGet, responseHandler);
        httpclient.getConnectionManager().shutdown();
        String[] lines = responseBody.split("\n");
        if (lines.length != currencyPairs.length) {
            throw new IllegalStateException("Currency data mismatch");
        }
        int i = 0;
        for (String line : lines) {
            CurrencyPair currencyPair = currencyPairs[i++];
            currencyPair.price = Float.parseFloat(line);
        }
    }
    public static void main(String[] args) {
        CurrencyConverterValue ycc = new CurrencyConverterValue();
        try {
            String[] currencies = new String[] { "USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "MXN", "ILS" };
            CurrencyPair[][] currencyPairs = ycc.getConversionMatrix(currencies);
            System.out.print("    ");
            for (int i = 0; i < currencyPairs.length; i++)
            {
                System.out.print("     " + currencies[i]);
            }
            System.out.println();
            for (int i = 0; i < currencyPairs.length; i++)
            {
                for (int j = 0; j < currencyPairs.length; j++)
                {
                    if (j == 0)
                    {
                        System.out.print(currencies[i] + " ");
                    }
                    CurrencyPair currencyPair = currencyPairs[i][j];
                    if (currencyPair != null)
                    {
                        System.out.printf("%8.3f", currencyPair.price);
                    }
                    else
                    {
                        System.out.print("        ");
                    }
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
