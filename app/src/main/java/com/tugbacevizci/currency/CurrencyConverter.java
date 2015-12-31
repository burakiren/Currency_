package com.tugbacevizci.currency;

/**
 * Created by Burakiren on 17/12/2015.
 */
public interface CurrencyConverter {
    public float convert(String currencyFrom, String currencyTo) throws Exception;
    public void convert(CurrencyPair[] currencyPairs) throws Exception;
}
