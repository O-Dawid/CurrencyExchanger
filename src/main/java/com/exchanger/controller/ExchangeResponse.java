package com.exchanger.controller;

import java.math.BigDecimal;

class ExchangeResponse{
    String toCurrency;
    String fromCurrnecy;
    BigDecimal amount;
    BigDecimal result;

    private ExchangeResponse(ExchangeResponseBuilder builder) {
        this.toCurrency = builder.toCurrency;
        this.fromCurrnecy = builder.fromCurrnecy;
        this.amount = builder.amount;
        this.result = builder.result;
    }


    public String getToCurrency() {
        return this.toCurrency;
    }

    public String getFromCurrnecy() {
        return this.fromCurrnecy;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getResult() {
        return this.result;
    }


    public static ExchangeResponseBuilder builder() {
        return new ExchangeResponseBuilder();
    }





    public static class ExchangeResponseBuilder{
        String toCurrency;
        String fromCurrnecy;
        BigDecimal amount;
        BigDecimal result;


        private ExchangeResponseBuilder(){

        }


        public ExchangeResponseBuilder setToCurrency(String toCurrency) {
            this.toCurrency = toCurrency;
            return this;
        }
        public ExchangeResponseBuilder setFromCurrnecy(String fromCurrnecy) {
            this.fromCurrnecy = fromCurrnecy;
            return this;
        }
        public ExchangeResponseBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }
        public ExchangeResponseBuilder setResult(BigDecimal result) {
            this.result = result;
            return this;
        }

        public ExchangeResponse build(){
            return new ExchangeResponse(this);
        }
        
    }
}