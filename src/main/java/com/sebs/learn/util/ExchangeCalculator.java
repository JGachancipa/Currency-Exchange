package com.sebs.learn.util;

import com.sebs.learn.model.ConcurrencyInfo;

import java.util.List;

public class ExchangeCalculator {

    public void calculateConvertedValues(List<ConcurrencyInfo> currencies, double value) {
        currencies.forEach(info -> info.setResult(value * info.getValue()));
    }
}
