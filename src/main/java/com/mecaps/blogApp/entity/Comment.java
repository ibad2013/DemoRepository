package com.mecaps.blogApp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String commentString;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Users author;

    private LocalDateTime commentAt = LocalDateTime.now();

}
