package com.felia.catlog.dto.member;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReservationsRequest(
                @NotBlank String userId,
                @NotBlank String branchId,
                String catId,
                @NotBlank String purpose,
                @NotNull LocalDate reservationDate,
                @NotNull LocalTime reservationTime,
                String memo) {
}