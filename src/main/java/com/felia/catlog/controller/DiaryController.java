package com.felia.catlog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felia.catlog.domain.DiaryPost;
import com.felia.catlog.dto.member.ButlerPostListItemResponse;
import com.felia.catlog.dto.member.DiaryPostResponse;
import com.felia.catlog.service.DiaryService;

@RestController
@RequestMapping("/api/diary-posts")
public class DiaryController {
  private final DiaryService diaryService;

  public DiaryController(DiaryService diaryService) {
    this.diaryService = diaryService;
  }

  @GetMapping
  public ResponseEntity<List<ButlerPostListItemResponse>> getDiaryPosts(){
    return ResponseEntity.ok(diaryService.getDiaryPosts());
  }

  @GetMapping("/{userId}")
  public ResponseEntity<List<DiaryPostResponse>> getUserDiaryPosts(@PathVariable String userId){
    return ResponseEntity.ok(diaryService.getUserDiaryPosts(userId));
  }
}
