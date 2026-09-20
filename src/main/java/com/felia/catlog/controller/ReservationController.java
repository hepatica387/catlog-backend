package com.felia.catlog.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.felia.catlog.dto.member.ReservationListItemDto;
import com.felia.catlog.dto.member.ReservationsRequest;
import com.felia.catlog.service.ReservationService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

/**
 * ReservationController
 */
@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {
  private final ReservationService service;

  @GetMapping("/members/{userId}")
  public ResponseEntity<List<ReservationListItemDto>> getReservations(@PathVariable String userId) {

    List<ReservationListItemDto> reservation = service.getReservations(userId);

    return ResponseEntity.ok(reservation);
  }

  @PostMapping
  public ResponseEntity<Map<String, Integer>> createReservation(
      @Valid @RequestBody ReservationsRequest request) {
    Integer reservationId = service.createReservation(request);

    return ResponseEntity
        .created(URI.create("/api/reservations/" + reservationId))
        .body(Map.of("reservationId", reservationId));
  }
}