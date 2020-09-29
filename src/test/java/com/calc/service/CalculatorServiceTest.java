package com.calc.service;

import com.calc.model.FunctionType;
import com.calc.model.ProviderType;
import com.calc.model.Tuple;
import com.calc.repo.TupleProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
    @InjectMocks
    CalculatorService calculatorService;
    @Mock
    TupleProvider tupleProvider;
    @Mock
    Map<String, TupleProvider> tupleProviderMap;

    @Before
    public void init() {
        when(tupleProviderMap.get(any(String.class))).thenReturn(tupleProvider);
        when(tupleProvider.getTuple()).thenReturn(
                Tuple.builder()
                        .firstNumber(4)
                        .secondNumber(10)
                        .build());

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateTest() {
        assertEquals(new BigDecimal(14), calculatorService.calculate(ProviderType.TWO_RANDOM_INT, FunctionType.ADDITION).getResult());
    }

}
