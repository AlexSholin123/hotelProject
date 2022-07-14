package com.example.hotelproject.controllers;

import com.example.hotelproject.models.Room;
import com.example.hotelproject.models.Staff;
import com.example.hotelproject.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    static ResponseEntity<Void> status = ResponseEntity.status(HttpStatus.OK).build();

    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable long id) {
        return ResponseEntity.of(roomService.get(id));
    }

    @PostMapping
    public ResponseEntity<Void> addRoom(@Valid @RequestBody  Room room) {
        roomService.add(room);
        return status;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editRoom(@PathVariable long id, Room room) {
        roomService.edit(id, room);
        return status;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        roomService.delete(id);
        return status;
    }
}
