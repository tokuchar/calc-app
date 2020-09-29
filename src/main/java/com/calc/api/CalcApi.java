package com.calc.api;

import com.calc.model.CalculationRequest;
import com.calc.model.CalculationResult;
import com.calc.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class CalcApi {
    final CalculatorService calculatorService;

    public CalcApi(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CalculationResult> addNumbers(@RequestBody CalculationRequest calculationRequest) {
        CalculationResult calculationResult = calculatorService.calculate(calculationRequest.getProviderType(), calculationRequest.getFunctionType());

        return ResponseEntity.ok(calculationResult);
    }
}
