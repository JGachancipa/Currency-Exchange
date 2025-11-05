package com.sebs.learn.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sebs.learn.dto.JsonResponse;
import com.sebs.learn.model.ConcurrencyInfo;
import com.sebs.learn.service.interfaces.ExchangeService;
import com.sebs.learn.util.ExchangeCalculator;
import com.sebs.learn.util.ExchangeUtil;

import java.util.List;

import static com.sebs.learn.util.Constants.BASE_URL;

public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeUtil util = new ExchangeUtil();
    private final ExchangeCalculator calculator = new ExchangeCalculator();

    @Override
    public ConcurrencyInfo getAllowedExchange(String baseExchange, String compareCode, double value) {
        try {
            String exchangeURL = BASE_URL + "/latest/" + baseExchange;
            String jsonResponse = util.getJsonFromApi(exchangeURL);

            List<ConcurrencyInfo> selected = util.extractSelectedCurrencies(jsonResponse);

            calculator.calculateConvertedValues(selected, value);
            return selected.stream()
                    .filter(info -> info.getCode().equalsIgnoreCase(compareCode))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
            return new ConcurrencyInfo();
        }
    }


    @Override
    public JsonResponse compareExchanges(String baseCode, String compareCode, double value) {
        try {
            String exchangeURL = BASE_URL + "/pair/" + baseCode + "/" + compareCode + "/" + value;
            String resp = util.getJsonFromApi(exchangeURL);
            return util.convertJSONToObject(resp);
        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
            return new JsonResponse();
        }
    }
}
