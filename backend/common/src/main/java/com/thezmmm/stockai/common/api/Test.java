package com.thezmmm.stockai.common.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {

    public static void main(String[] args) throws Exception {

        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://finnhub.io/api/v1/stock/symbol?exchange=US&token=d5mcephr01qt66a6550gd5mcephr01qt66a65510"))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        }catch (Exception e){

        }
    }
}
