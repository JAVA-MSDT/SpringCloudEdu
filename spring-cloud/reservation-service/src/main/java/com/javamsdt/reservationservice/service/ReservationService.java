package com.javamsdt.reservationservice.service;

import java.util.Date;
import java.util.List;

import com.javamsdt.reservationservice.entity.Reservation;
import com.javamsdt.reservationservice.respository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByReservationsDate(Date reservationDate) {
        return reservationRepository.findReservationsByReservationDate(new java.sql.Date(reservationDate.getTime()));
    }

    public Reservation getReservation(long id) {
        return reservationRepository.findById(id).get();
    }

    public void AddReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
