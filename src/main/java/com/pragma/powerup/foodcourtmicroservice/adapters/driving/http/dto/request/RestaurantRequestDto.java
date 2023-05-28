package com.pragma.powerup.foodcourtmicroservice.adapters.driving.http.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantRequestDto {
    private Long id;
    private String name;
    private String address;
    private Long idOwner;
    private String phone;
    private String urlLogo;
    private String nit;

}
