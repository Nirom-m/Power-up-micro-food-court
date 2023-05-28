package com.pragma.powerup.foodcourtmicroservice.domain.usercase;

import com.pragma.powerup.foodcourtmicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.foodcourtmicroservice.domain.datasource.IUserClientPort;
import com.pragma.powerup.foodcourtmicroservice.domain.model.Restaurant;
import com.pragma.powerup.foodcourtmicroservice.domain.spi.IRestaurantPersistencePort;

public class RestaurantUserCase implements IRestaurantServicePort {

    private IRestaurantPersistencePort restaurantPersistencePort;
    private IUserClientPort userClientPort;

    public RestaurantUserCase(IRestaurantPersistencePort restaurantPersistencePort, IUserClientPort userClientPort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userClientPort = userClientPort;
    }


    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantPersistencePort.saveRestaurant(restaurant);
    }
}
