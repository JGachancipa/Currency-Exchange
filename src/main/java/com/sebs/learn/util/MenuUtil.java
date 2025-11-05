package com.sebs.learn.util;

import com.sebs.learn.dto.JsonResponse;
import com.sebs.learn.model.ConcurrencyInfo;
import com.sebs.learn.service.impl.ExchangeServiceImpl;
import com.sebs.learn.service.interfaces.ExchangeService;

public class MenuUtil {
    private static final ExchangeService service = new ExchangeServiceImpl();

    public ConcurrencyInfo validateUserRequest(int option, double amount) {
        return switch (option) {
            case 1 -> service.getAllowedExchange("USD", "ARS", amount);
            case 2 -> service.getAllowedExchange("ARS", "USD", amount);
            case 3 -> service.getAllowedExchange("USD", "BRL", amount);
            case 4 -> service.getAllowedExchange("BRL", "USD", amount);
            case 5 -> service.getAllowedExchange("USD", "COP", amount);
            case 6 -> service.getAllowedExchange("COP", "USD", amount);
            default -> null;
        };
    }

    public JsonResponse validateWithAnotherCodes(String baseCode, String compareCode, double amount) {
        return service.compareExchanges(baseCode, compareCode, amount);
    }
}
