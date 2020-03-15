package com.exchanger.service;

import java.math.BigDecimal;

public interface CurrencyExchanger{
    BigDecimal makeDeal(BigDecimal amount, String currentCurrency, String targetCurrency);
}