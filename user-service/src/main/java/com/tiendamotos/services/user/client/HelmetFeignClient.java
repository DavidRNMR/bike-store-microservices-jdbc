package com.tiendamotos.services.user.client;

import com.tiendamotos.services.user.model.HelmetModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "helmet-service")
public interface HelmetFeignClient {

    @GetMapping("/findByUser/{userId}")
    HelmetModel findByUser(@PathVariable Long userId);

    @PostMapping("/addHelmet")
    HelmetModel addOne (@RequestBody HelmetModel helmet);
}
