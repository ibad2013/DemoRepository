package com.mecaps.blogApp.responseDTO;


import com.mecaps.blogApp.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponseDTO {

    private Long id;
    private String content;
    private Long authorId;
    private LocalDateTime postAt;

    public PostResponseDTO(Post post) {

        this.id = post.getId();
        this.content = post.getContent();
        this.authorId = post.getAuthor().getId();
        this.postAt = post.getPostedAt();
    }
}
