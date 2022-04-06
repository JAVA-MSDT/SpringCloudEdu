package com.javamsdt.roomservice.service;

import java.util.List;

import com.javamsdt.roomservice.entity.Room;
import com.javamsdt.roomservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }
}
