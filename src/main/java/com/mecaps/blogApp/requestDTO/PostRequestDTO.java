package com.mecaps.blogApp.requestDTO;

import com.mecaps.blogApp.entity.Users;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDTO {
    @NotBlank(message = "Content is required")
    private String content;
    @NotNull(message = "Author id must not be Null")
    private Long authorId;
}
