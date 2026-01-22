package com.thezmmm.stockai.backendstock.api.dto;

import lombok.Data;

/**
 * @author MYH
 * @date 2026/1/22 21:05
 * @description: FinnhubSearchResponse Represents the response from Finnhub stock search API
 */
@Data
public class FinnhubSearchResponse {

    private int count;
    private FinnhubStockInfo[] result;
}
