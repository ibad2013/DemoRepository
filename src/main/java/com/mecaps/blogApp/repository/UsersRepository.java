package com.mecaps.blogApp.repository;


import com.mecaps.blogApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
  Optional<Users> findByUserName(String name);
  Optional<Users> findByEmail(String email);
//    "select * from users where userName = ?"
//    Users findByUserName(String name);
//
//    "select * from users where name = ? and email = ?"
//    Users findByUserNameAndEmail(String name, String email);
//
//
//    "select * from users where name = ? or email = ?"
//    Users findByUserNameOrEmail(String name, String email);



}
