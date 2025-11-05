package com.sebs.learn.service.interfaces;

import com.sebs.learn.dto.JsonResponse;
import com.sebs.learn.model.ConcurrencyInfo;

import java.util.List;

public interface ExchangeService {
    ConcurrencyInfo getAllowedExchange(String baseCode, String compareCode, double value);

    JsonResponse compareExchanges(String baseCode, String compareCode, double value);

}
