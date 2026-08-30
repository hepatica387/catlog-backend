package com.felia.catlog.dto.member;

public record ButlerPostListItemResponse(
    Long postId,
    String title,
    String thumbnailUrl,
    String authorName
) {}