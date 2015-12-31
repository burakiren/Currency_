package com.tugbacevizci.currency;

/**
 * Created by Burakiren on 17/12/2015.
 */
public abstract class BaseCurrencyConverter implements CurrencyConverter
{

    public CurrencyPair[][] getConversionMatrix(String... currencies) throws Exception
    {
        // Build pair combinations
        int size = currencies.length;
        CurrencyPair[] currencyPairs = new CurrencyPair[size * size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currencyPairs[index++] = new CurrencyPair(currencies[i], currencies[j]);
            }
        }
        // Get currencies information
        convert(currencyPairs);
        // Build matrix
        CurrencyPair[][] matrix = new CurrencyPair[size][size];
        index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = i != j ? currencyPairs[index] : null;
                index++;
            }
        }
        return matrix;
    }
}
