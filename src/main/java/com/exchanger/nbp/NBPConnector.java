package com.exchanger.nbp;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.exchanger.dto.CurrencyRate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NBPConnector {

    public Map<String, CurrencyRate> getCurrentExchangeRates(){
        String urlGetList = "http://api.nbp.pl/api/exchangerates/tables/A";
        RestTemplate restTemplate = new RestTemplate();
        // // PROSTE POBRANIE API
        // ResponseEntity<NBPResponse[]> responseEntity = restTemplate.getForEntity(urlGetList, NBPResponse[].class);
        // NBPResponse[] nbpResponses = responseEntity.getBody();
        
        // List <NBPCurrency> list = nbpResponses[0].getRates();
        // for (NBPCurrency i:list){
        //     System.out.println(i.toString());
        // }
        

        // // PROFESJONALNE POBRANIE API
        // final RequestEntity<Void> requestA = RequestEntity.get(URI.create("http://api.nbp.pl/api/exchangerates/tables/A"))
        // .accept(MediaType.APPLICATION_JSON)
        // .build();
        // final ResponseEntity<? extends Collection<NBPResponse>> responseA = restTemplate.exchange(requestA, new ParameterizedTypeReference<Collection<NBPResponse>>() {
        // });
        // final Collection<NBPCurrency> listA = responseA.getBody().stream().findAny().get().getRates();
        // for (NBPCurrency i:listA){
        //     System.out.println(i.toString());
        // }

        // UPROSZCZONE POBRANIE API
        ResponseEntity<Collection<NBPResponse>> responseEntity1 = restTemplate.exchange(urlGetList, HttpMethod.GET, null, new ParameterizedTypeReference<Collection<NBPResponse>>(){});
        List<NBPCurrency> nbpResponses1 = responseEntity1.getBody().stream().findAny().get().getRates();
        // for (NBPCurrency i:nbpResponses1){
        //     System.out.println(i.toString());
        // }
        Map<String, CurrencyRate> currencies = nbpResponses1.stream()
                                                            .map(NBPConnector::toCurrencyRate)
                                                            .collect(Collectors.toMap(CurrencyRate::getCode, Function.identity()));
        
        currencies.put("PLN", new CurrencyRate("PLN", BigDecimal.valueOf(1).setScale(2)));

        return currencies;
    }

    private static CurrencyRate toCurrencyRate(NBPCurrency nbpCurrency){
        return new CurrencyRate(nbpCurrency.getCode(), new BigDecimal(nbpCurrency.getMid()));
    }
 
}