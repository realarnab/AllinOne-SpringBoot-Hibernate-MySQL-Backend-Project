package com.allinone.service.impl;

import com.allinone.payload.UserDto;
import com.allinone.repository.UserRepository;
import com.allinone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceimpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }
}
