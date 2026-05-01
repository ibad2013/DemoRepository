package com.mecaps.blogApp.requestDTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    @NotBlank(message = "commentString is required")
    private String commentString;
    @NotNull(message = "post id must not be null")
    private Long postId;
    @NotNull(message =  "User id must not be null")
    private Long authorId;
}
