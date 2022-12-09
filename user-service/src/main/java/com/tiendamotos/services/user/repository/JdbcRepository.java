package com.tiendamotos.services.user.repository;

import com.tiendamotos.services.user.client.BikeFeignClient;
import com.tiendamotos.services.user.model.BikeModel;
import com.tiendamotos.services.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class JdbcRepository implements UserRepository{

    String findAll ="SELECT * FROM users";
    String findById = "SELECT * FROM users WHERE id=?";
    String sqlSave ="INSERT INTO users (name, email) VALUES (?, ?)";
    String deleteById = "DELETE FROM users WHERE id=?";
    String sqlUpdate ="UPDATE users SET name = ?, email = ? WHERE id = ?";
    String sqlEmail ="SELECT * FROM users WHERE email = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BikeFeignClient client;



    @Override
    public int save (UserModel user) {
        return jdbcTemplate.update(sqlSave,user.getName(),user.getEmail());
    }

    @Override
    public void update(UserModel user) {
        jdbcTemplate.update(sqlUpdate,user.getName(),user.getEmail(),user.getId());

    }

    @Override
    public UserModel findOne(Long id) {
        return jdbcTemplate.queryForObject(findById, new BeanPropertyRowMapper<UserModel>(UserModel.class),id);
    }

    @Override
    public List<UserModel> findAll() {
        return jdbcTemplate.query(findAll, new BeanPropertyRowMapper<UserModel>(UserModel.class));
    }

    @Override
    public UserModel findByEmail(String email) {
        return jdbcTemplate.queryForObject(sqlEmail, new BeanPropertyRowMapper<UserModel>(UserModel.class),email);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(deleteById,id);
    }


    public BikeModel saveBike(Long userId,BikeModel bike){

        bike.setUserId(userId);
        BikeModel bikeNew = client.save(bike);
        return bikeNew;
    }
}
