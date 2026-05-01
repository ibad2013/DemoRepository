package com.mecaps.blogApp.responseDTO;

import com.mecaps.blogApp.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDTO {

    private Long id;
    private String commentString;
    private Long postId;
    private Long authorId;

    public CommentResponseDTO(Comment comment) {
        this.id = comment.getId();
        this.commentString = comment.getCommentString();
        this.postId = comment.getPost().getId();
        this.authorId = comment.getAuthor().getId();
    }
}
