package com.exchanger.nbp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class NBPCurrency {
    @Getter
    @Setter
    String currency;
    @Getter
    @Setter
    String code;
    @Getter
    @Setter
    String mid;

}