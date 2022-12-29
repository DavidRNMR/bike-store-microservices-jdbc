package com.tiendamotos.services.user.controller;

import com.tiendamotos.services.user.model.BikeModel;
import com.tiendamotos.services.user.model.HelmetModel;
import com.tiendamotos.services.user.model.UserModel;
import com.tiendamotos.services.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRepository repository;


    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserModel>> findAll (){

        List<UserModel> users = repository.findAll();

        if(users.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/findOneUser/{id}")
    public ResponseEntity<UserModel> findOne (@PathVariable Long id){

        UserModel user = repository.findOne(id);

        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<UserModel> findByEmail (@PathVariable String email){

        UserModel user = repository.findByEmail(email);

        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser (@RequestBody UserModel user){

        return  ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> update (@PathVariable Long id, @RequestBody UserModel user){

        UserModel user1 = repository.findOne(id);

        if(user1!=null){

            user1.setName(user.getName());
            user1.setEmail(user.getEmail());

            repository.update(user1);
            return new ResponseEntity<>("User updated", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserModel> delete (@PathVariable Long id){

        try{
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<?> getUser (@PathVariable Long userId){

        BikeModel bike = repository.findByUserId(userId);

        if(bike!=null){
            return new ResponseEntity<>(bike,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/saveBike/{userId}")
    ResponseEntity<BikeModel> saveBike (@PathVariable Long userId, @RequestBody BikeModel bike){

        return  ResponseEntity.status(HttpStatus.CREATED).body(repository.saveBike(bike,userId));

    }
    @GetMapping("/findAllBikes/{userId}")
    public ResponseEntity <List<BikeModel>> findAllBikes (@PathVariable Long userId){

        List<BikeModel> bikes = repository.findAllByUser(userId);

        if(bikes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(bikes, HttpStatus.OK);
        }
    }
    @GetMapping("/findOneHelmet/{userId}")
    public ResponseEntity<HelmetModel> findOneHelmet (@PathVariable Long userId){

        HelmetModel helmet = repository.findByUser(userId);

        if(helmet!=null){
            return new ResponseEntity<>(helmet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/addHelmet/{userId}")
    public ResponseEntity<HelmetModel> addHelmet (@RequestBody HelmetModel helmet, @PathVariable Long userId){

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.addOne(helmet,userId));
    }

    @GetMapping("/findAllByUser/{id}/{userId}")
    public ResponseEntity<UserModel> findAllByUser (@PathVariable Long id, @PathVariable Long userId){

        UserModel userModel = repository.findEverythingByUser(id,userId);
        return new ResponseEntity<>(userModel,HttpStatus.OK);
    }
}
