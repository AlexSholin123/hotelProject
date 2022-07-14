package com.example.hotelproject.controllers;

import com.example.hotelproject.models.Staff;
import com.example.hotelproject.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable long id) {
        return ResponseEntity.of(staffService.get(id));
    }

    @PostMapping
    public ResponseEntity<Void> addStaff(@Valid @RequestBody Staff staff) {
        staffService.add(staff);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editStaff(@PathVariable long id, Staff staff) {
        staffService.edit(id, staff);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable long id) {
        staffService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
