package com.thezmmm.stockai.backendstock.api.dto;

import lombok.Data;

/**
 * @author MYH
 * @date 2026/1/22 21:01
 * @description: StockInfo Represents stock information
 */
@Data
public class FinnhubStockInfo {

    private String symbol;        // Unique stock identifier
    private String displaySymbol; // Display symbol name
    private String description;   // Stock description / name
    private String type;          // Stock type, e.g., Common Stock

    // Fields specific to Stock Symbol API
    private String currency;      // Currency, e.g., USD
    private String figi;          // FIGI identifier
    private String mic;           // Exchange MIC code

}
