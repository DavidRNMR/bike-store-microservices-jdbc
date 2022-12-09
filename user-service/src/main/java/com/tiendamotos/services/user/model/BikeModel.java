package com.tiendamotos.services.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BikeModel {

    private String manufacturer;
    private BigDecimal prize;
    private Integer horsePower;
    private Long userId;
}
