package com.felia.catlog.service;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.felia.catlog.domain.Reservation;
import com.felia.catlog.dto.member.ReservationsRequest;
import com.felia.catlog.repository.CatRepository;
import com.felia.catlog.repository.MemberRepository;
import com.felia.catlog.repository.ReservationRepository;

@Service
public class ReservationService {

  private final ReservationRepository repository;
  private final MemberRepository memberRepository;
  private final CatRepository catRepository;

  public ReservationService(
      ReservationRepository repository,
      MemberRepository memberRepository,
      CatRepository catRepository) {
    this.repository = repository;
    this.memberRepository = memberRepository;
    this.catRepository = catRepository;
  }

  public Integer createReservation(ReservationsRequest request) {
    LocalDateTime reservationAt = LocalDateTime.of(
        request.reservationDate(),
        request.reservationTime());

    if (!reservationAt.isAfter(LocalDateTime.now())) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "예약 시간은 현재 시간 이후여야 합니다.");
    }

    if (!memberRepository.existsByUserId(request.userId())) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "존재하지 않는 회원입니다.");
    }

    if (request.catId() != null
        && !catRepository.existsById(request.catId())) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "존재하지 않는 고양이입니다.");
    }

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
