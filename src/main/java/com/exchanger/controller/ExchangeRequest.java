package com.exchanger.controller;

import lombok.Getter;
import lombok.Setter;

class ExchangeRequest{
    @Getter
    @Setter
    // @NotBlank
    String valueBefore;
    @Getter
    @Setter
    // @NotBlank
    String currencyCodeBefore;
    @Getter
    @Setter
    // @NotBlank
    String targetCurrnecyCode;
}