package com.tiendamotos.services.helmet.repository;

import com.tiendamotos.services.helmet.model.HelmetModel;

import java.util.List;

public interface HelmetRepository {

    int save (HelmetModel helmet);
    List<HelmetModel> findAll();
    HelmetModel findOne (Long id);
    List<HelmetModel>findAllByBrand(String brand);
    HelmetModel findByUser (Long userHelmet);
    void deleteById(Long id);


}
