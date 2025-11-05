package com.sebs.learn.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sebs.learn.dto.JsonResponse;
import com.sebs.learn.model.ConcurrencyInfo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static com.sebs.learn.util.Constants.SELECTED_CODES;


public class ExchangeUtil {
    private static final HttpClient client = HttpClient.newHttpClient();

    public String getJsonFromApi(String endpoint) throws Exception {
        HttpRequest req = HttpRequest.newBuilder(URI.create(endpoint)).GET().build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        return resp.body();
    }

    public JsonResponse convertJSONToObject(String json) {
        return new Gson().fromJson(json, JsonResponse.class);
    }

    public List<ConcurrencyInfo> extractSelectedCurrencies(String json) {
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();
        JsonObject rates = root.getAsJsonObject("conversion_rates");

        List<ConcurrencyInfo> list = new ArrayList<>();
        SELECTED_CODES.forEach(code -> {
            if (rates.has(code)) {
                double value = rates.get(code).getAsDouble();
                list.add(new ConcurrencyInfo(code, value, 0.0));
            }
        });
        return list;
    }
}
