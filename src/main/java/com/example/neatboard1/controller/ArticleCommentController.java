package com.example.neatboard1.controller;

import com.example.neatboard1.dto.UserAccountDto;
import com.example.neatboard1.dto.request.ArticleCommentRequest;
import com.example.neatboard1.dto.security.BoardPrincipal;
import com.example.neatboard1.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public String postNewArticleComment(
            ArticleCommentRequest articleCommentRequest,
            @AuthenticationPrincipal BoardPrincipal boardPrincipal
        ) {
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(
                boardPrincipal.toDto()
        ));

        return "redirect:/articles/" + articleCommentRequest.articleId();
    }


    @PostMapping("/{commentId}/delete")
    public String deleteArticleComment(
            @PathVariable("commentId") Long commentId,
            @AuthenticationPrincipal BoardPrincipal boardPrincipal,
            @RequestParam("articleId") Long articleId) {
        articleCommentService.deleteArticleComment(commentId, boardPrincipal.getUsername());

        return "redirect:/articles/" + articleId;
    }
}
