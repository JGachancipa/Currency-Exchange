package com.sebs.learn.model;

public class ConcurrencyInfo {
    private String code;
    private double value;
    private double result;

    public ConcurrencyInfo() {
    }

    public ConcurrencyInfo(String code, double value, double result) {
        this.code = code;
        this.value = value;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ConcurrencyInfo {" +
                "code='" + code + '\'' +
                ", value=" + value +
                ", result=" + result +
                '}';
    }

}
