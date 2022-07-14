package com.example.hotelproject.services;

import com.example.hotelproject.models.Room;
import com.example.hotelproject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public Optional<Room> get(long id) {
        return roomRepository.findById(id);
    }

    public Room add(Room room) {
        return roomRepository.save(room);
    }

    public void edit(long id, Room editedRoom) {
        editedRoom.setId(id);
        roomRepository.save(editedRoom);
    }

    public void delete(long id) {
        roomRepository.deleteById(id);
    }

}
