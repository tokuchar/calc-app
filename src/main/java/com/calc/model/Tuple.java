package com.calc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Tuple {
    Number firstNumber;
    Number secondNumber;
}
