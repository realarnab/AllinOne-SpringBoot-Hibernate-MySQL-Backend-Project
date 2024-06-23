package com.allinone.service;

import com.allinone.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAll();

    UserDto getUserById(long id);

    void deleteUser(long id);

    UserDto updateUser(long id, UserDto dto);
}
