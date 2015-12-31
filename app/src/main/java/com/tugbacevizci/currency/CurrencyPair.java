package com.tugbacevizci.currency;

/**
 * Created by Burakiren on 17/12/2015.
 */
public class CurrencyPair {
    private String from;
    private String to;
    float price;
    public CurrencyPair(String from, String to)
    {
        this.from = from;
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public float getPrice()
    {
        return price;
    }
}