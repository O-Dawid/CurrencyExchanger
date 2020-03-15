package com.exchanger.service;

import java.util.Map;

import com.exchanger.dto.CurrencyRate;
import com.exchanger.nbp.NBPConnector;

import org.springframework.stereotype.Service;

@Service
public class CurrencyRatesImp implements CurrencyRates {

    NBPConnector connector;
    Map<String, CurrencyRate> currencies;


    public CurrencyRatesImp(NBPConnector connector) {
        this.connector = connector;
        setDb();
    }
    
    public void setDb(){
        System.out.println("ELKO");
        currencies = connector.getCurrentExchangeRates();
    }

    @Override
    public CurrencyRate findByCode(String code) {
        
        return currencies.get(code);
    }

    
}
