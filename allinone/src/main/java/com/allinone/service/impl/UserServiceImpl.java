package com.allinone.service.impl;

import com.allinone.entity.User;
import com.allinone.payload.LoginDto;
import com.allinone.payload.UserDto;
import com.allinone.repository.UserRepository;
import com.allinone.service.JWTService;
import com.allinone.service.UserService;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JWTService jwtService;
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

    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapToDto(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(long id, UserDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        int update = userRepository.update(id, dto.getName(), dto.getEmail());
        if (update==0){
            throw new RuntimeException("Something went wrong");
        } else {
            return dto;
        }
    }

    @Override
    public String verifyLogin(LoginDto loginDto) {
        Optional<User> opUser = userRepository.findByUsername(loginDto.getUsername());

        if (opUser.isPresent()){
            User user = opUser.get();
            boolean check = BCrypt.checkpw(loginDto.getPassword(), user.getPassword());

            if (check){
                return jwtService.generateToken(user);
            }
        }
        return null;
    }

    public UserDto mapToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public User mapToEntity(UserDto dto){
        return modelMapper.map(dto,User.class);
    }
}
