package com.thezmmm.stockai.backendstock.api;

import com.thezmmm.stockai.backendstock.api.dto.StockSearchResponse;
import com.thezmmm.stockai.backendstock.api.dto.StockInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FinnhubClientTest {

    @Autowired
    private FinnhubClient finnhubClient;

    @Test
    void testGetAllStocks() {
        List<StockInfo> stocks = finnhubClient.getAllStocks();
        assertNotNull(stocks);
        assertFalse(stocks.isEmpty(), "Stock list should not be empty");
        System.out.println("First stock: " + stocks.get(0));
    }

    @Test
    void testSearchStocks() {
        StockSearchResponse response = finnhubClient.searchStocks("AAPL");
        assertNotNull(response);
        System.out.println("Search results: " + response.getResult());
    }
}
