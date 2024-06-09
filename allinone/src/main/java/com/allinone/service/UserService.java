package com.allinone.service;

import com.allinone.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAll();

    UserDto getUserById(long id);
}
