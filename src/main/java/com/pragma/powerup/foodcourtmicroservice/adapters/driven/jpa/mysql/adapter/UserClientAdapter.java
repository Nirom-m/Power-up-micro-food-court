package com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.foodcourtmicroservice.adapters.driven.jpa.mysql.restClient.IUserClient;
import com.pragma.powerup.foodcourtmicroservice.domain.datasource.IUserClientPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserClientAdapter implements IUserClientPort {

    private final IUserClient userClient;
    @Override
    public boolean getUser(Long id) {
        return userClient.validUserOwner(id);
    }
}
