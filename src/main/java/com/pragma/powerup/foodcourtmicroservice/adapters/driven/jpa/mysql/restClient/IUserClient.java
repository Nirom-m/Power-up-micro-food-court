package com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usermicroservice", url = "http://localhost:8090")
public interface IUserClient {

    @GetMapping("/user/{id}")
    boolean validUserOwner(@PathVariable("id") Long id);
}
