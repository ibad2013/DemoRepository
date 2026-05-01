package com.mecaps.blogApp.controller;

import com.mecaps.blogApp.entity.Comment;
import com.mecaps.blogApp.requestDTO.CommentRequestDTO;
import com.mecaps.blogApp.responseDTO.CommentResponseDTO;
import com.mecaps.blogApp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping("/create")
    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO requestDTO){
        return commentService.createComment(requestDTO);
    }
    @GetMapping("/all")
   public List<CommentResponseDTO> getall(){
        return commentService.getallComment();
    }
    @DeleteMapping("/delete/{id}")
    public  String deleted (@PathVariable Long Commentid){
      return commentService.deletecomment(Commentid);
    }
    @PatchMapping("update/{id}")
    public  CommentResponseDTO update(@PathVariable Long id , @RequestBody CommentRequestDTO requestDTO){
        return commentService.commentUpdate(id, requestDTO);
    }
    @GetMapping("get/{id}")
    public List  <CommentResponseDTO> getbyAuthorID (@PathVariable Long authorid){
        List<CommentResponseDTO> comments = commentService.getallCommentsByAuthor(authorid);
        return  comments;
    }
}

