package com.mecaps.blogApp.service;

import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.requestDTO.UserRequestDTO;
import com.mecaps.blogApp.responseDTO.UsersResponseDTO;

import java.util.List;

public interface UserService {


    UsersResponseDTO createUsers(UserRequestDTO request);

    UsersResponseDTO getById(Long id);

    List<UsersResponseDTO> getAll();

    UsersResponseDTO updateUsers(Long id,
                                 UserRequestDTO request);


    String deleteUser(Long id);

}
