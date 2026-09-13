package com.felia.catlog.dto.member;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationListItemDto(
    String branchId,
    String catId,
    LocalDate reservationDate,
    LocalTime reservationTime,
    String purpose,
    String status,
    String memo
) {
}