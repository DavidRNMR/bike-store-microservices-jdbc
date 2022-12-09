package com.tiendamotos.services.bike.repository;

import com.tiendamotos.services.bike.model.BikeModel;

import java.math.BigDecimal;
import java.util.List;

public interface BikeRepository {

    int save (BikeModel bike);

    void update (BikeModel bike);

    BikeModel findById (Long id);

    void deleteById(Long id);

    List<BikeModel> findAll();

    List<BikeModel> findByManufacturer(String manufacturer);

    List<BikeModel> findByPrize (BigDecimal prize);

    List<BikeModel> findByUser (Long userId);
}
