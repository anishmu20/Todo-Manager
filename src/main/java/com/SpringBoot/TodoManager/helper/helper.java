package com.SpringBoot.TodoManager.helper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class helper {

    public static Date parse(LocalDateTime localDateTime){

        Instant instant=localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        return date;


    }
}
