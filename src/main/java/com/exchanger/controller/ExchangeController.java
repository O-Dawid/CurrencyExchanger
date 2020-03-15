package com.exchanger.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import com.exchanger.service.CurrencyExchanger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    CurrencyExchanger currencyExchanger;

    public ExchangeController(CurrencyExchanger currencyExchanger) {
        this.currencyExchanger = currencyExchanger;
    }

    @PostMapping("/")
    public ExchangeResponse makeADeal(@RequestBody @Valid ExchangeRequest exchangeRequest) {
        System.out.println(currencyExchanger.makeDeal(new BigDecimal(exchangeRequest.getValueBefore()), exchangeRequest.currencyCodeBefore, exchangeRequest.targetCurrnecyCode));
        
        
        
        BigDecimal result = currencyExchanger.makeDeal(new BigDecimal(exchangeRequest.getValueBefore()), exchangeRequest.currencyCodeBefore, exchangeRequest.targetCurrnecyCode);
        ExchangeResponse exchangeResponse = ExchangeResponse.builder()
                                            .setAmount(new BigDecimal(exchangeRequest.getValueBefore()))
                                            .setFromCurrnecy(exchangeRequest.currencyCodeBefore)
                                            .setToCurrency(exchangeRequest.targetCurrnecyCode)
                                            .setResult(result)
                                            .build();
        return exchangeResponse;
                                            
    }

}