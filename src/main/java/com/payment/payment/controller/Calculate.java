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
    public double getPayment(@RequestParam String start, @RequestParam String end, @RequestParam int salary){
        int countWeekend = calculateService.countWeekend(calculateService.getCalendar(start),calculateService.getCalendar(end));
        return calculateService.getPayment(salary, countWeekend);
    }
}
