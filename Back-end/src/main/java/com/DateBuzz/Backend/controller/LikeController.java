package com.DateBuzz.Backend.controller;

import com.DateBuzz.Backend.controller.responseDto.Response;
import com.DateBuzz.Backend.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    @PostMapping("community/{recordId}/likes")
    public Response<Void> likeRecord(@PathVariable Long recordId, Authentication authentication){
        likeService.like(recordId, authentication.getName());
        return Response.success();
    }
}
