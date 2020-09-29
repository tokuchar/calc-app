package com.calc.function;

import com.calc.model.Tuple;

@FunctionalInterface
public interface TupleFunction {
    public Number apply(Tuple tuple);
}
