package com.tiendamotos.services.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel {

    private Long id;
    private String name;
    private String email;
    private List<BikeModel> bikes;

}
