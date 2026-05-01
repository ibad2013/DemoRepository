package com.mecaps.blogApp.service;

import com.mecaps.blogApp.entity.Comment;
import com.mecaps.blogApp.requestDTO.CommentRequestDTO;
import com.mecaps.blogApp.responseDTO.CommentResponseDTO;

import java.util.List;

public interface CommentService {


    CommentResponseDTO createComment(CommentRequestDTO requestDTO);
    List<CommentResponseDTO> getallCommentsByAuthor(Long authorid);
    CommentResponseDTO commentUpdate (Long commentid , CommentRequestDTO commentRequestDTO);
    List<CommentResponseDTO> getallComment();
    String deletecomment(Long commentid);
}
