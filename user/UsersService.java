package com.insuagg1.service;

import com.insuagg1.entity.Users;
import com.insuagg1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(int id) {
        Optional<Users> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(int id, Users user) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
