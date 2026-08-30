package com.felia.catlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felia.catlog.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
