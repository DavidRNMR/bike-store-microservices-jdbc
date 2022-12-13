package com.tiendamotos.services.bike.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BikeModel {

    private Long id;
    private String manufacturer;
    private BigDecimal prize;
    private Integer horsePower;
    private Long userId;
}
