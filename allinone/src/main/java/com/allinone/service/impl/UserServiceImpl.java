package com.allinone.service.impl;

import com.allinone.entity.User;
import com.allinone.payload.UserDto;
import com.allinone.repository.UserRepository;
import com.allinone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user=new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());

        User saved = userRepository.save(user);

        userDto.setId(saved.getId());
        userDto.setName(saved.getName());
        userDto.setUsername(saved.getUsername());
        userDto.setEmail(saved.getEmail());
        userDto.setPassword(saved.getPassword());
        userDto.setUserRole(saved.getUserRole());
        return userDto;
    }
}
