package com.javamsdt.guestservices.webservice;

import java.util.List;

import com.javamsdt.guestservices.entity.Guest;
import com.javamsdt.guestservices.service.GuestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guests")
public class GuestRestController {

    private final GuestService guestService;

    public GuestRestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.findAllGuests();
    }

    @GetMapping(value = "/{id}")
    public Guest getGuestById(@PathVariable(value = "id") long id) {
        return guestService.getGuestById(id);
    }
}
