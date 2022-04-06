package com.javamsdt.reservationservice.respository;

import java.sql.Date;
import java.util.List;

import com.javamsdt.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

     List<Reservation> findReservationsByReservationDate(Date date);
}
