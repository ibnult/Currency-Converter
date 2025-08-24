package com.example.currency_converter;

public class CurrencyConversion {
    private String from;
    private String to;
    private double amount;
    private double result;

    public CurrencyConversion(String from, String to, double amount, double result) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.result = result;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public double getAmount() { return amount; }
    public double getResult() { return result; }
}
