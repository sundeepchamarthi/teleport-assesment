package com.teleport.service;

import com.teleport.dto.UserDTO;
import com.teleport.entity.User;
import com.teleport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserDTO dto) {
        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .build();
        return userRepository.save(user);
    }
}
