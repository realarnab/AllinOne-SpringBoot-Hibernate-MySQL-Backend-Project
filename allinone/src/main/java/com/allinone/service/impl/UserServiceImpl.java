package com.allinone.service.impl;

import com.allinone.entity.User;
import com.allinone.payload.UserDto;
import com.allinone.repository.UserRepository;
import com.allinone.service.UserService;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
//        User user=new User();
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setUsername(userDto.getUsername());
//        user.setPassword(userDto.getPassword());
//        user.setUserRole(userDto.getUserRole());
        User user = mapToEntity(userDto);

        User saved = userRepository.save(user);

//        userDto.setId(saved.getId());
//        userDto.setName(saved.getName());
//        userDto.setUsername(saved.getUsername());
//        userDto.setEmail(saved.getEmail());
//        userDto.setPassword(saved.getPassword());
//        userDto.setUserRole(saved.getUserRole());
        UserDto dto = mapToDto(saved);
        return dto;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map((element) -> modelMapper.map(element, UserDto.class)).collect(Collectors.toList());
    }

    public UserDto mapToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public User mapToEntity(UserDto dto){
        return modelMapper.map(dto,User.class);
    }
}
