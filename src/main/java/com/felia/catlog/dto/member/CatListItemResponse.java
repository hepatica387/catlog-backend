package com.felia.catlog.dto.member;

public record CatListItemResponse(
        String catId,
        Integer breedId,
        String name,
        Integer ageMonth,
        String imageUrl) {
}