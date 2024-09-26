package com.payment.payment.controller;

import com.payment.payment.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Calculate {
    @Autowired
    private CalculateService calculateService;
    @PostMapping("/calculacte")
    public double getPayment(@RequestParam(required = false) Integer countDays,@RequestParam(required = false) String start, @RequestParam(required = false) String end, @RequestParam int salary){
        return calculateService.choiceOfCalculationMethod(countDays, start, end, salary);
    }
}
