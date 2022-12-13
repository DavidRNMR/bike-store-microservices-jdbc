package com.tiendamotos.services.user.client;

import com.tiendamotos.services.user.model.BikeModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="bike-service")
public interface BikeFeignClient {


    @GetMapping("/findByUserId/{userId}")
    BikeModel findByUserId(@PathVariable Long userId);



}
