package com.exchanger.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.exchanger.dto.CurrencyRate;
import com.exchanger.service.CurrencyExchanger;
import com.exchanger.service.CurrencyExchangerImp;
import com.exchanger.service.CurrencyRates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CurrencyExchanger currencyExchanger;

	@Test
	void shouldNotExchangeItself() {
		currencyExchanger = new CurrencyExchangerImp(new DummiesData());
		BigDecimal result = currencyExchanger.makeDeal(new BigDecimal("1000"), "USD", "USD");
		assertEquals(new BigDecimal("1000").setScale(0), result.setScale(0), "messageSupplier");
	}

	@Test
	void shouldCorrectExchangePLNToUSD() {
		currencyExchanger = new CurrencyExchangerImp(new DummiesData());
		BigDecimal result = currencyExchanger.makeDeal(new BigDecimal("1000"), "USD", "PLN");
		assertEquals(new BigDecimal("2000").setScale(0), result.setScale(0), "messageSupplier");
	}

	@Test
	void shouldThownNullException() {
		currencyExchanger = new CurrencyExchangerImp(new DummiesData());	
		Assertions.assertThrows(RuntimeException.class, ()->currencyExchanger.makeDeal(new BigDecimal("1000"), "", "PLN"));	
	}

	@Test
	void shouldThownNotFoundCodeException() {
		currencyExchanger = new CurrencyExchangerImp(new DummiesData());	
		Assertions.assertThrows(RuntimeException.class, ()->currencyExchanger.makeDeal(new BigDecimal("1000"), "SADFG", "PLN"));	
	}

	public class DummiesData implements CurrencyRates {

		CurrencyRate pln = new CurrencyRate("PLN", new BigDecimal(1));
		CurrencyRate usd = new CurrencyRate("USD", new BigDecimal(2));
		CurrencyRate eur = new CurrencyRate("EUR", new BigDecimal(3));


		@Override
		public CurrencyRate findByCode(String code) {
			switch (code) {
                case "USD":
                    return usd;
                case "EUR":
                    return eur;
                case "PLN":
                    return pln;
            }
			return null;
		}
		
	}

}
