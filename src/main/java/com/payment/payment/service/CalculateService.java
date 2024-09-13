package com.payment.payment.service;

import ch.qos.logback.core.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

@Service
public class CalculateService {

    public int countWeekend(GregorianCalendar start, GregorianCalendar end){
        if(start != null && end != null) {
            HashSet<String> holidays = new HashSet<>(14);
            holidays.add("01:01");
            holidays.add("02:01");
            holidays.add("03:01");
            holidays.add("04:01");
            holidays.add("05:01");
            holidays.add("06:01");
            holidays.add("07:01");
            holidays.add("08:01");
            holidays.add("23:02");
            holidays.add("08:03");
            holidays.add("01:05");
            holidays.add("09:05");
            holidays.add("12:06");
            holidays.add("04:11");
            int workDayCounter = 0;
            DateFormat df = new SimpleDateFormat("dd:MM");
            while (start.compareTo(end) < 1) {
                if (start.get(Calendar.DAY_OF_WEEK) != 7 && start.get(Calendar.DAY_OF_WEEK) != 1 && holidays.contains(df.format(start.getTime())) == false) {
                    workDayCounter++;
                }
                if (start.getActualMaximum(Calendar.DAY_OF_MONTH) == start.get(Calendar.DAY_OF_MONTH)) {
                    start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH) + 1, 1);
                } else {
                    start.roll(Calendar.DAY_OF_MONTH, 1);
                }
            }
            return workDayCounter;
        }else{
            return 0;
        }
    }

    public GregorianCalendar getCalendar(String date){
        if(StringUtils.countMatches(date,"-")==2){
            String[] splitDate = date.split("-");
            var startCalendar = new GregorianCalendar(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]) -1,Integer.parseInt(splitDate[0]));
            return startCalendar;
        }else{
            return null;
        }
    }

    public double getPayment(int salary, int countWeekend){
        if(salary > 0)
            return Math.round(salary/12/29.3*countWeekend*100)/100;
        else
            return 0;
    }
}
