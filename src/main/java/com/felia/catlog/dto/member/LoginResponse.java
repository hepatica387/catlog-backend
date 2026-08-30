package com.felia.catlog.dto.member;

// 응답용 DTO
public record LoginResponse(
    String userId,
    String userName,
    String email) {

}
