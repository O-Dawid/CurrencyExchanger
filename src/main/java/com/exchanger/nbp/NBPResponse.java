package com.exchanger.nbp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class NBPResponse {
    @Getter
    @Setter
    String table;
    @Getter
    @Setter
    String no;
    @Getter
    @Setter
    String effectiveDate;
    @Getter
    @Setter
    List<NBPCurrency> rates;
}