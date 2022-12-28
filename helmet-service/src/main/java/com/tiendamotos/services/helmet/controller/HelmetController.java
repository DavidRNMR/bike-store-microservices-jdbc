package com.tiendamotos.services.helmet.controller;

import com.tiendamotos.services.helmet.model.HelmetModel;
import com.tiendamotos.services.helmet.repository.HelmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelmetController {

    @Autowired
    private HelmetRepository repository;

    @GetMapping("/findAll")
    public ResponseEntity<List<HelmetModel>> findAll (){

        List<HelmetModel> helmets = repository.findAll();

        if(helmets.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(helmets,HttpStatus.OK);
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<HelmetModel> findById (@PathVariable Long id){

        HelmetModel helmet = repository.findOne(id);

        if(helmet!=null){

            return new ResponseEntity<>(helmet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByBrand/{brand}")
    public ResponseEntity<List<HelmetModel>> findByBrand(@PathVariable String brand){

        List<HelmetModel> helmets = repository.findAllByBrand(brand);

        if(helmets.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(helmets,HttpStatus.OK);
    }

    @PostMapping("/addHelmet")
    public ResponseEntity<?> addOne (@RequestBody HelmetModel helmet){

        repository.save(helmet);

        return new ResponseEntity<>(helmet, HttpStatus.CREATED);
    }

    @GetMapping("/findByUser/{userId}")
    public ResponseEntity<HelmetModel> findByUser(@PathVariable Long userId){

        HelmetModel helmetModel = repository.findByUser(userId);

        if(helmetModel!=null){

            return new ResponseEntity<>(helmetModel,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HelmetModel> delete (@PathVariable Long id){

        if(id!=null){

            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
