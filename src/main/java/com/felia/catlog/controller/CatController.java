package com.felia.catlog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felia.catlog.domain.Cat;
import com.felia.catlog.dto.member.CatListItemResponse;
import com.felia.catlog.service.CatService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/cats")
public class CatController {

  private final CatService catService;

  public CatController(CatService catService) {
    this.catService = catService;
  }

  @PostMapping()
  public String addCat(Cat cat) {
    return "redirect:/";
  }

  @GetMapping()
  public ResponseEntity<List<Cat>> catList() {
    List<Cat> cats = catService.getCats();
    return ResponseEntity.ok(cats);
  }

  @GetMapping("/top7")
  public List<CatListItemResponse> getcatListItem() {
    return catService.findRecontCat();
  }

  @GetMapping("/{catId}")
  public String detailCat() {
    return "/cats/{catId}";
  }

}
