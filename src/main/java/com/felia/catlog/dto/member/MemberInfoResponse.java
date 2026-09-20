package com.felia.catlog.dto.member;

import java.time.LocalDate;

public record MemberInfoResponse(
    String userId,
    String userName,
    String email,
    String phone,
    LocalDate birthday,
    LocalDate create_at) {

}
