package com.exchanger.service;

import com.exchanger.dto.CurrencyRate;

public interface CurrencyRates {

    public CurrencyRate findByCode(String code);
}
