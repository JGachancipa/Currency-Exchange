package com.sebs.learn.dto;

import com.google.gson.annotations.SerializedName;

public class JsonResponse {
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("target_code")
    private String compareCode;
    @SerializedName("conversion_result")
    private double conversionRate;

    public JsonResponse() {
    }

    public JsonResponse(String baseCode, String compareCode, double conversionRate) {
        this.baseCode = baseCode;
        this.compareCode = compareCode;
        this.conversionRate = conversionRate;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getCompareCode() {
        return compareCode;
    }

    public void setCompareCode(String compareCode) {
        this.compareCode = compareCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return "JsonResponse {" +
                "baseCode='" + baseCode + '\'' +
                ", compareCode='" + compareCode + '\'' +
                ", conversionRate=" + conversionRate +
                '}';
    }

}
