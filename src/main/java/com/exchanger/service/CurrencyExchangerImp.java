package com.exchanger.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.exchanger.dto.CurrencyRate;

import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangerImp implements CurrencyExchanger{
    
    CurrencyRates rates;


    public CurrencyExchangerImp(CurrencyRates rates) {
        this.rates = rates;
    }



    @Override
    public BigDecimal makeDeal(BigDecimal amount, String currentCurrency, String targetCurrency) {
        // 1000 PLN TO USD = 1000 /3,81
        //USD - 3,81 PLN
        //Get CurrentCurrency EUR = 4,31 PLN
        CurrencyRate fromCurrency = rates.findByCode(currentCurrency);
        //Get TargetCurrnecy USD = 3,81 PLN
        CurrencyRate toCurrency = rates.findByCode(targetCurrency);
        if(fromCurrency==null || toCurrency == null){
            throw new RuntimeException("Code not found");
        }
        //Get Amount
        BigDecimal fromRate = fromCurrency.getMid();
        BigDecimal toRate = toCurrency.getMid();
        //Return Amount*(CurrentCurrency/TargetCurrency)

        
        return amount.multiply(fromRate).divide(toRate, RoundingMode.HALF_UP);
    }




}