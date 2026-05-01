package com.mecaps.blogApp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users")
@Setter
@Getter
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String email;
    private String role;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    private List<Post> posts;





}
