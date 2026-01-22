package com.thezmmm.stockai.backendstock.api;

import com.thezmmm.stockai.backendstock.api.dto.Quote;
import com.thezmmm.stockai.backendstock.api.dto.StockSearchResponse;
import com.thezmmm.stockai.backendstock.api.dto.StockInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author MYH
 * @date 2026/1/21 15:19
 * @description: FinnhubClient Implementation of StockApiClient for Finnhub API
 */
@Component
public class FinnhubClient implements StockApiClient{
    private final String apiKey;
    private final String baseUrl;
    private final RestTemplate restTemplate;

    public FinnhubClient(
            @Value("${finnhub.api.key}") String apiKey,
            @Value("${finnhub.api.url:https://finnhub.io/api/v1}") String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
    }

    /**
     * Get all stocks
     *
     * @return List of FinnhubStockInfo
     */
    @Override
    public List<StockInfo> getAllStocks() {
        try{
            String url = String.format("%s/stock/symbol?exchange=US&token=%s", baseUrl, apiKey);
            StockInfo[] stocks = restTemplate.getForObject(url, StockInfo[].class);
            if (stocks == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(stocks);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * Search stocks by query
     *
     * @param query search query
     * @return FinnhubSearchResponse
     */
    @Override
    public StockSearchResponse searchStocks(String query) {
        try {
            String url = String.format("%s/search?q=%s&token=%s", baseUrl, query, apiKey);
            StockSearchResponse response = restTemplate.getForObject(url, StockSearchResponse.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get real-time quote data for US stocks.
     *
     * @param symbol
     * @return FinnhubQuote
     */
    @Override
    public Quote getQuote(String symbol) {
        try {
            String url = String.format("%s/quote?symbol=%s&token=%s", baseUrl, symbol, apiKey);
            Quote quote = restTemplate.getForObject(url, Quote.class);
            return quote;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
