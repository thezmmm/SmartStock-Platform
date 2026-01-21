package com.thezmmm.stockai.common.api;

/**
 * @author MYH
 * @date 2026/1/21 15:19
 * @description: FinnhubClient Implementation of StockApiClient for Finnhub API
 */
public class FinnhubClient implements StockApiClient{
    private final String apiKey;
    private final String baseUrl;

    public FinnhubClient(String apiKey,String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }
}
