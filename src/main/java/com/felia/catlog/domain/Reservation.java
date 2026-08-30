package com.felia.catlog.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id")
  private Integer reservationId;

  @Column(name = "user_id", length = 50, nullable = false)
  private String userId;

  @Column(name = "branch_id", length = 20, nullable = false)
  private String branchId;

  @Column(name = "cat_id", length = 50)
  private String catId;

  @Column(name = "reservation_date", nullable = false)
  private LocalDate reservationDate;

  @Column(name = "reservation_time", nullable = false)
  private LocalTime reservationTime;

  @Column(name = "purpose", length = 30, nullable = false)
  private String purpose;

  @Column(name = "status", length = 20, nullable = false)
  private String status;

  @Column(name = "memo", length = 255)
  private String memo;
}
