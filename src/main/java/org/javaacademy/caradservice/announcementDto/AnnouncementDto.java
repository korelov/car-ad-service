package org.javaacademy.caradservice.announcementDto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class AnnouncementDto {
    String brand;
    String color;
    BigDecimal price;
    String model;
    LocalDate date;
}
