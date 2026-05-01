package com.mecaps.blogApp.repository;

import com.mecaps.blogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findByAuthor_Id(Long id);



//    "select * from post where author = 1"
//    List<Post> findByAuthor(Long id);
//
//
//    "select * from post where author.id = ?"
//    List<Post> findByAuthor_Id(Long id);
//
//
//    List<Post> findByAuthor_Id(Users user);

//    List<Post> findAllByOrderByPostedAtDesc();


}
