package com.calc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CalculationRequest {
    ProviderType providerType;
    FunctionType functionType;
}
