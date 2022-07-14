package com.example.hotelproject.controllers;

import com.example.hotelproject.models.HotelUser;
import com.example.hotelproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<HotelUser> getUser(@PathVariable long id) {
        return ResponseEntity.of(userService.get(id));
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@Valid @RequestBody HotelUser user) {
        userService.add(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editUser(@PathVariable long id, HotelUser user) {
        userService.edit(id, user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
