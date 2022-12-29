package com.tiendamotos.services.user.repository;

import com.tiendamotos.services.user.model.BikeModel;
import com.tiendamotos.services.user.model.HelmetModel;
import com.tiendamotos.services.user.model.UserModel;
import java.util.List;


public interface UserRepository {

    int save (UserModel user);

    void update (UserModel user);

    UserModel findOne (Long id);

    List<UserModel> findAll();

    UserModel findByEmail (String email);

    void deleteById (Long id);

    BikeModel findByUserId (Long userId);

    BikeModel saveBike (BikeModel bike,Long userId);

    List<BikeModel> findAllByUser (Long userId);

    HelmetModel findByUser (Long userId);

    HelmetModel addOne (HelmetModel helmet, Long userId);

    UserModel findEverythingByUser(Long id, Long userId);

}
