package com.calc.repo;

import com.calc.model.Tuple;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository("TWO_RANDOM_INT")
public class RandomIntProvider implements TupleProvider {
    @Override
    public Tuple getTuple() {
        Random random = new Random();
        return Tuple.builder()
                .firstNumber(random.nextInt(100))
                .secondNumber(random.nextInt(100)).build();
    }
}
