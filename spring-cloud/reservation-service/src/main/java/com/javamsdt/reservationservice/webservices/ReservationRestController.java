package com.javamsdt.reservationservice.webservices;

import java.util.Date;
import java.util.List;

import com.javamsdt.reservationservice.entity.Reservation;
import com.javamsdt.reservationservice.service.ReservationService;
import com.javamsdt.reservationservice.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public ReservationRestController(ReservationService reservationService,
            DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservation();
    }

    @GetMapping(value = "/date")
    public List<Reservation> getReservation(@RequestParam(value = "date", required = false) String reservationDate) {
        Date date = this.dateUtils.createDateFromDateString(reservationDate);
        return  this.reservationService.getReservationsByReservationsDate(date);
    }

    @GetMapping(value = "/{id}")
    public Reservation getReservation(@PathVariable(value = "id") long id) {
        return reservationService.getReservation(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void AddReservation(@RequestBody Reservation reservation) {
        reservationService.AddReservation(reservation);
    }

}
