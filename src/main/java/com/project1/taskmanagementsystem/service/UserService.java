package com.project1.taskmanagementsystem.service;

import com.project1.taskmanagementsystem.dto.UserDto;
import com.project1.taskmanagementsystem.model.User;
import com.project1.taskmanagementsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserDto createUser(UserDto userDto) {
        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        User savedUser=userRepository.save(user);

        return convertToDto(savedUser);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }


    public UserDto getUserById(Long userId) {
        Optional<User> userOptional =userRepository.findById(userId);
        return userOptional.map(this::convertToDto).orElse(null);
    }

    public UserDto getUserByUsername(String username) {
        Optional<User> userOptional=userRepository.findByUsername(username);
        return userOptional.map(this::convertToDto).orElse(null);

    }


    public List<UserDto> getAllUsers() {
      List<User> users =userRepository.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }
}
