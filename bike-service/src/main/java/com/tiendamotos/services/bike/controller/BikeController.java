package com.tiendamotos.services.bike.controller;

import com.tiendamotos.services.bike.model.BikeModel;
import com.tiendamotos.services.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;


@RestController
public class BikeController {

    @Autowired
    private BikeRepository repository;

    @GetMapping("/findAllBikes")
    public ResponseEntity<List<BikeModel>> getAllBikes(){

        List<BikeModel> bikes= repository.findAll();

        if(bikes.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(bikes,HttpStatus.OK);
        }
    }

    @GetMapping("/bikes/{id}")
    public ResponseEntity<BikeModel> getBikeById(@PathVariable Long id){

        BikeModel bike= repository.findById(id);

        if(bike!=null){
            return new ResponseEntity<>(bike,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
    }

    @PostMapping("/addBike")
    public ResponseEntity<?> addBike(@RequestBody BikeModel bike){

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(bike));
    }

    @PutMapping("/bike/{id}")
    public ResponseEntity<String> update (@PathVariable Long id, @RequestBody BikeModel bike){

    BikeModel bike1 = repository.findById(id);

    if(bike1!=null){

        bike1.setManufacturer(bike.getManufacturer());
        bike1.setPrize(bike.getPrize());
        bike1.setHorsePower(bike.getHorsePower());

        repository.update(bike1);
        return new ResponseEntity<>("Bike Updated", HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    @DeleteMapping("/bike/{id}")
    public ResponseEntity<BikeModel> delete (@PathVariable Long id){

        try{
            repository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }


    @GetMapping("/findAllManufacturers/{manufacturer}")
    public ResponseEntity<List<BikeModel>> findAllManufacturers(@PathVariable String manufacturer){

        try{
            List<BikeModel> bikes = repository.findByManufacturer(manufacturer);

            if(bikes.isEmpty()){

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bikes,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAllBikesByPrize/{prize}")
    public ResponseEntity<List<BikeModel>> findAllByPrize (@PathVariable BigDecimal prize){

        try{
            List<BikeModel> bikes = repository.findByPrize(prize);

            if(bikes.isEmpty()){

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bikes, HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
