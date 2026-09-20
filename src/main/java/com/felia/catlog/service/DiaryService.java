package com.felia.catlog.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felia.catlog.domain.DiaryPost;
import com.felia.catlog.domain.Member;
import com.felia.catlog.dto.member.ButlerPostListItemResponse;
import com.felia.catlog.dto.member.DiaryPostResponse;
import com.felia.catlog.repository.DiaryPostRepository;
import com.felia.catlog.repository.MemberRepository;

@Service
public class DiaryService {
  private final MemberRepository memberRepository;
  private final DiaryPostRepository diaryPostRepository;

  public DiaryService(DiaryPostRepository diaryPostRepository, MemberRepository memberRepository) {
    this.diaryPostRepository = diaryPostRepository;
    this.memberRepository = memberRepository;
  }

  @Transactional(readOnly = true)
  public List<ButlerPostListItemResponse> getDiaryPosts() {
    List<DiaryPost> posts = diaryPostRepository.findByIsPublicTrueOrderByCreatedAtDescPostIdDesc();

    if (posts.isEmpty()) {
      return List.of();
    }

    List<String> userIds = posts.stream().map(DiaryPost::getUserId).distinct().toList();

    Map<String, String> authorNames = memberRepository.findAllById(userIds)
        .stream()
        .collect(Collectors.toMap(
            Member::getUserId,
            Member::getUserName));

    return posts.stream().map(
        post -> new ButlerPostListItemResponse(
            post.getPostId(),
            post.getTitle(),
            post.getThumbnailUrl(),
            authorNames.getOrDefault(post.getUserId(), "알수없는 사용자")))
        .toList();
  }

  public List<DiaryPostResponse> getUserDiaryPosts(String userId){
    List<DiaryPost> res = diaryPostRepository.findByUserIdOrderByCreatedAtDesc(userId);

    if(res.isEmpty()){
      return List.of();
    }

    List<String> userIds = res.stream().map(DiaryPost::getUserId).distinct().toList();

    Map<String, String> authorNames = memberRepository.findAllById(userIds)
        .stream()
        .collect(Collectors.toMap(
            Member::getUserId,
            Member::getUserName));

    return res.stream().map(
      post -> new DiaryPostResponse(
          post.getPostId(),
          post.getTitle(),
          post.getThumbnailUrl(),
          authorNames.getOrDefault(post.getUserId(), "알수없는 사용자"),
          post.getCreatedAt(),
          post.getLikeCount(),
          post.getViewCount()))
      .toList();

            
  }
}
