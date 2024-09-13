package com.payment.payment.CalculateService;

import com.payment.payment.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculateServiceTest {
    @Autowired
    private CalculateService calculateService;
    @Test
    public void shouldReturnCalendarOrNull(){

    }

}
