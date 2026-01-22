package com.thezmmm.stockai.backendstock.api;

import com.thezmmm.stockai.backendstock.api.dto.FinnhubSearchResponse;
import com.thezmmm.stockai.backendstock.api.dto.FinnhubStockInfo;
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
    public List<FinnhubStockInfo> getAllStocks() {
        try{
            String url = String.format("%s/stock/symbol?exchange=US&token=%s", baseUrl, apiKey);
            FinnhubStockInfo[] stocks = restTemplate.getForObject(url, FinnhubStockInfo[].class);
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
    public FinnhubSearchResponse searchStocks(String query) {
        try {
            String url = String.format("%s/search?q=%s&token=%s", baseUrl, query, apiKey);
            FinnhubSearchResponse response = restTemplate.getForObject(url, FinnhubSearchResponse.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
