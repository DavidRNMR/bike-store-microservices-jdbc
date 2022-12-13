package com.tiendamotos.services.bike.repository;


import com.tiendamotos.services.bike.model.BikeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class JdbcBikeRepository implements BikeRepository {

     String sqlSave ="INSERT INTO bikes (manufacturer, prize, horsepower, userId) VALUES (?, ?, ?, ?)";
     String sqlUpdate ="UPDATE bikes SET manufacturer = ?, prize = ?, horsepower = ? WHERE id = ?";
     String findById = "SELECT * FROM bikes WHERE id=?";
     String deleteById = "DELETE FROM bikes WHERE id=?";
     String findAll = "SELECT * FROM bikes";
     String findAllByPrize = "SELECT * FROM bikes WHERE prize=?";
     String findByUser = "SELECT * FROM bikes WHERE userId=?";
     String sqlUserId = "SELECT * FROM bikes WHERE userId = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(BikeModel bike) {

        return jdbcTemplate.update(sqlSave, bike.getManufacturer(),bike.getPrize(),
                bike.getHorsePower(), bike.getUserId());
    }

    @Override
    public void update(BikeModel bike) {
        jdbcTemplate.update(sqlUpdate, bike.getManufacturer(), bike.getPrize(),
                bike.getHorsePower());

    }

    @Override
    public BikeModel findById (Long id) {

      return jdbcTemplate.queryForObject(findById, new BeanPropertyRowMapper<BikeModel>(BikeModel.class),id);

    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(deleteById, id);
    }

    @Override
    public List<BikeModel> findAll() {
        return jdbcTemplate.query(findAll,BeanPropertyRowMapper.newInstance(BikeModel.class));
    }

    @Override
    public List<BikeModel> findByManufacturer(String manufacturer) {
        String sql ="SELECT * FROM bikes WHERE manufacturer LIKE '%" + manufacturer
        + "%'";
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(BikeModel.class));
    }

    @Override
    public List<BikeModel> findByPrize(BigDecimal prize) {
        return jdbcTemplate.query(findAllByPrize, BeanPropertyRowMapper.newInstance(BikeModel.class)
        ,prize);

    }

    @Override
    public List<BikeModel> findByUser(Long userId) {
        return jdbcTemplate.query(findByUser,BeanPropertyRowMapper.newInstance(BikeModel.class)
        ,userId);
    }

    @Override
    public BikeModel findByUserId(Long userId) {
        return jdbcTemplate.queryForObject(sqlUserId,new BeanPropertyRowMapper<BikeModel>(BikeModel.class),userId);
    }
}
