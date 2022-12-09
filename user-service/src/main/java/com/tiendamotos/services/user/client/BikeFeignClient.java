package com.tiendamotos.services.user.client;

import com.tiendamotos.services.user.model.BikeModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name="bike-service")
public interface BikeFeignClient {


    @PostMapping()
    BikeModel save(@RequestBody BikeModel bike);



}
