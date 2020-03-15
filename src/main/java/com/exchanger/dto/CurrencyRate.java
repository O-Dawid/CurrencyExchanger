package com.exchanger.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CurrencyRate{
    @Getter
    @Setter
    String code;
    @Getter
    @Setter
    BigDecimal mid;
}