package com.felia.catlog.service;

import org.springframework.stereotype.Service;

import com.felia.catlog.domain.Reservation;
import com.felia.catlog.dto.member.ReservationsRequest;
import com.felia.catlog.repository.ReservationRepository;

@Service
public class ReservationService {

  private final ReservationRepository repository;

  public ReservationService(ReservationRepository repository) {
    this.repository = repository;
  }

  public Integer createReservation(ReservationsRequest request) {
    Reservation reservation = new Reservation();

    reservation.setUserId(request.userId());
    reservation.setBranchId(request.branchId());
    reservation.setCatId(request.catId());
    reservation.setPurpose(request.purpose());
    reservation.setReservationDate(request.reservationDate());
    reservation.setReservationTime(request.reservationTime());
    reservation.setMemo(request.memo());
    reservation.setStatus("PENDING");

    Reservation saveReservation = repository.save(reservation);

    return saveReservation.getReservationId();

  }
}
