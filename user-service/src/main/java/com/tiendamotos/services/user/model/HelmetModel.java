package com.tiendamotos.services.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HelmetModel {

    private Long id;
    private String brand;
    private String size;
    private Long userId;

    public HelmetModel( Long userId){
        this.userId = userId;
    }
}
