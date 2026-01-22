package com.thezmmm.stockai.backendstock.api;


import com.thezmmm.stockai.backendstock.api.dto.Quote;
import com.thezmmm.stockai.backendstock.api.dto.StockSearchResponse;
import com.thezmmm.stockai.backendstock.api.dto.StockInfo;

import java.util.List;

/**
 * @author MYH
 * @date 2026/1/21 15:14
 * @description: StockApiClient Provide methods for obtaining stock-related data for backend modules to use
 */
public interface StockApiClient {

    /**
     * Get all stocks
     * @return List of FinnhubStockInfo
     */
    public List<StockInfo> getAllStocks();

    /**
     * Search stocks by query
     * @param query search query
     * @return FinnhubSearchResponse
     */
    public StockSearchResponse searchStocks(String query);

    /**
     * Get real-time quote data for US stocks.
     * @param symbol
     * @return FinnhubQuote
     */
    public Quote getQuote(String symbol);
}
