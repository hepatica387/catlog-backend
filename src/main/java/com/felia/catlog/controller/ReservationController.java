package com.felia.catlog.controller;

import java.net.URI;
import java.net.URL;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  public ResponseEntity<Map<String, Integer>> createReservation(@Valid @RequestBody ReservationsRequest request) {
    Integer reservationId = service.createReservation(request);

    return ResponseEntity
        .created(URI.create("/api/reservations/" + reservationId))
        .body(Map.of("reservationId", reservationId));
  }
}