package com.calc.service;

import com.calc.function.TupleFunction;
import com.calc.model.CalculationResult;
import com.calc.model.FunctionType;
import com.calc.model.ProviderType;
import com.calc.model.Tuple;
import com.calc.repo.TupleProvider;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatorService {
    private final Map<String, TupleProvider> tupleProviderMap;
    private final Map<String, TupleFunction> operations = new HashMap<String, TupleFunction>() {{
        put(FunctionType.ADDITION.name(), tuple -> new BigDecimal(tuple.getFirstNumber().toString()).add(new BigDecimal(tuple.getSecondNumber().toString())));
    }};

    public CalculatorService(Map<String, TupleProvider> tupleProviderMap) {
        this.tupleProviderMap = tupleProviderMap;
    }

    public CalculationResult calculate(ProviderType providerType, FunctionType functionType){
        Tuple tuple = getTuple(providerType);
        TupleFunction tupleFunction = operations.get(functionType.name());

        Number result = tupleFunction.apply(tuple);

        return CalculationResult.builder()
                .tuple(tuple)
                .result(result).build();
    }

    private Tuple getTuple(ProviderType providerType) {
        TupleProvider tupleProvider = tupleProviderMap.get(providerType.name());
        return tupleProvider.getTuple();
    }
}
