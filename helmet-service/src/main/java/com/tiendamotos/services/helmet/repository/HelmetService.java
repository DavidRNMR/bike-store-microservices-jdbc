package com.tiendamotos.services.helmet.repository;

import com.tiendamotos.services.helmet.model.HelmetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HelmetService implements HelmetRepository {

    String findAll ="SELECT * FROM helmets";
    String save = "INSERT INTO helmets (brand, size, userId) VALUES (?, ?, ?)";
    String findOne = "SELECT * FROM helmets WHERE id = ?";
    String findAllByBrand = "SELECT * FROM helmets WHERE brand = ?";
    String findByUser = "SELECT * FROM helmets WHERE userId = ?";
    String delete = "DELETE FROM helmets WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(HelmetModel helmet) {
        return jdbcTemplate.update(save,helmet.getBrand(),helmet.getSize(), helmet.getUserId());
    }

    @Override
    public List<HelmetModel> findAll() {
        return jdbcTemplate.query(findAll, new BeanPropertyRowMapper<HelmetModel>(HelmetModel.class));
    }

    @Override
    public HelmetModel findOne(Long id) {
        return jdbcTemplate.queryForObject(findOne, new BeanPropertyRowMapper<HelmetModel>(HelmetModel.class),id);
    }

    @Override
    public List<HelmetModel> findAllByBrand(String brand) {
        return jdbcTemplate.query(findAllByBrand, new BeanPropertyRowMapper<HelmetModel>(HelmetModel.class),brand);
    }

    @Override
    public HelmetModel findByUser(Long userHelmet) {
        return jdbcTemplate.queryForObject(findByUser, new BeanPropertyRowMapper<HelmetModel>(HelmetModel.class),userHelmet);
    }

    @Override
    public void deleteById(Long id) {

        jdbcTemplate.update(delete,id);

    }
}
