package com.tiendamotos.services.user.repository;

import com.tiendamotos.services.user.model.UserModel;

import java.util.List;

public interface UserRepository {

    int save (UserModel user);

    void update (UserModel user);

    UserModel findOne (Long id);

    List<UserModel> findAll();

    UserModel findByEmail (String email);

    void deleteById (Long id);

}
