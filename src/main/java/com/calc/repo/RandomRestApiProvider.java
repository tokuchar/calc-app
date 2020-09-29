package com.calc.repo;

import com.calc.model.Tuple;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Repository("RANDOM_REST_API")
public class RandomRestApiProvider implements TupleProvider {
    @Override
    public Tuple getTuple() {
        RestTemplate restTemplate = new RestTemplate();
        String[] ints = restTemplate
                .getForEntity("https://www.random.org/integers/?num=2&min=1&max=100&col=1&base=10&format=plain&rnd=new", String.class)
                .getBody()
                .split("\\r?\\n");

        return Tuple.builder()
                .firstNumber(new BigDecimal(ints[0]))
                .secondNumber(new BigDecimal(ints[1])).build();
    }
}
