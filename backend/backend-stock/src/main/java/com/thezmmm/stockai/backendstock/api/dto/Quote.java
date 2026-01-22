package com.thezmmm.stockai.backendstock.api.dto;


import lombok.Data;

/**
 * @author MYH
 * @date 2026/1/22 21:50
 * @description: FinnhubQuote Represents the stock quote information from Finnhub API
 */
@Data
public class Quote {

    /**
     * c: Current price
     */
    private double c;

    /**
     * h: High price of the day
     */
    private double h;
    /**
     * l: Low price of the day
     */
    private double l;
    /**
     * o: Open price of the day
     */
    private double o;
    /**
     * pc: Previous close price
     */
    private double pc;
    /**
     * t: Timestamp
     */
    private long t;
}
