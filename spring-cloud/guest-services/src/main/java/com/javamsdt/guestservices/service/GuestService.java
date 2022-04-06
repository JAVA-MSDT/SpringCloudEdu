package com.javamsdt.guestservices.service;

import java.util.List;

import com.javamsdt.guestservices.entity.Guest;
import com.javamsdt.guestservices.repository.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAllGuests() {
       return this.guestRepository.findAll();
    }

    public Guest getGuestById(long id) {
        return guestRepository.findById(id).get();
    }
}
