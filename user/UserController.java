package com.insuagg1.controller;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.insuagg1.entity.Users;
import com.insuagg1.service.UsersService;
 
@RestController
@RequestMapping("/users")
public class UserController {
 
    @Autowired
    private UsersService userService;
 
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        Users user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users user) {
        Users updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

