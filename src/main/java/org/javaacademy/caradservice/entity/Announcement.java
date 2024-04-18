package org.javaacademy.caradservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.NonNull;



@Data
public class Announcement {
    @NonNull
    private String id;
    @NonNull
    private String brand;
    @NonNull
    private String color;
    @NonNull
    private BigDecimal price;
    @NonNull
    private String model;
    @NonNull
    private LocalDate date;
}
