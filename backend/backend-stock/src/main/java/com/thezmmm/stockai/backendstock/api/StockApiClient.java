package com.thezmmm.stockai.backendstock.api;


import com.thezmmm.stockai.backendstock.api.dto.FinnhubSearchResponse;
import com.thezmmm.stockai.backendstock.api.dto.FinnhubStockInfo;

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
    public List<FinnhubStockInfo> getAllStocks();

    /**
     * Search stocks by query
     * @param query search query
     * @return FinnhubSearchResponse
     */
    public FinnhubSearchResponse searchStocks(String query);
}
