package com.tiendamotos.services.helmet.repository;

import com.tiendamotos.services.helmet.model.HelmetModel;

import java.util.List;

public interface HelmetRepository {

    int save (HelmetModel helmet);
    List<HelmetModel> findAll();
    HelmetModel findOne (Long userId);
    List<HelmetModel>findAllByBrand(String brand);
    HelmetModel findByUser (Long userId);
    void deleteById(Long userId);


}
