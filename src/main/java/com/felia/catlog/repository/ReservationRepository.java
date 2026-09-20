package com.felia.catlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felia.catlog.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  List<Reservation> findByUserIdOrderByReservationTimeDesc(String userId);
}
