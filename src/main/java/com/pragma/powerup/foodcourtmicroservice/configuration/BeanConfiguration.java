package com.pragma.powerup.foodcourtmicroservice.configuration;

import com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.adapter.RestaurantMysqlAdapter;
import com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.adapter.UserClientAdapter;
import com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.restClient.IUserClient;
import com.pragma.powerup.foodcourtmicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.foodcourtmicroservice.domain.datasource.IUserClientPort;
import com.pragma.powerup.foodcourtmicroservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.foodcourtmicroservice.domain.usercase.RestaurantUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final IRestaurantRepository restaurantRepository;
    private final IUserClient userClient;

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(){
        return new RestaurantMysqlAdapter(restaurantEntityMapper, restaurantRepository);
    }
    @Bean
    public IUserClientPort userClientPort(){
        return new UserClientAdapter(userClient);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort(){
        return new RestaurantUserCase(restaurantPersistencePort(), userClientPort());
    }

}
