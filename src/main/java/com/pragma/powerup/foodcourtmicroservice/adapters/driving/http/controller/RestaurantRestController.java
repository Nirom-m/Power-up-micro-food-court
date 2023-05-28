package com.pragma.powerup.foodcourtmicroservice.adapters.driving.http.controller;

import com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.restClient.IUserClient;
import com.pragma.powerup.foodcourtmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.foodcourtmicroservice.adapters.driving.http.handlers.IRestaurantHandler;
import com.pragma.powerup.foodcourtmicroservice.configuration.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor

public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;
    private final IUserClient userClient;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> createRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto){
        // Obtener el ID del usuario desde el microservicio de usuarios
        Long userId = restaurantRequestDto.getIdOwner();
        boolean isValidUser = userClient.validUserOwner(userId);

        if (!isValidUser) {
            // El usuario no es válido
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PERSON_NOT_FOUND_MESSAGE));
        }

        restaurantHandler.saveRestaurant(restaurantRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.USER_CREATED_MESSAGE));
    }
}
