package com.mecaps.blogApp.controller;

import com.mecaps.blogApp.requestDTO.UserRequestDTO;
import com.mecaps.blogApp.responseDTO.UsersResponseDTO;
import com.mecaps.blogApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {


    private UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/getById/{id}")
    public UsersResponseDTO getUserById(@PathVariable Long id){
       UsersResponseDTO usersResponseDTO =  userService.getById(id);
       return usersResponseDTO;
    }


    @GetMapping("/getAll")
    public List<UsersResponseDTO> getAllUsers(){
        return userService.getAll();
    }


    @PostMapping("/create")
    public UsersResponseDTO createUsers(@Valid @RequestBody UserRequestDTO requestDTO) {
        return userService.createUsers(requestDTO);
    }
        @PatchMapping("/update/{id}")
        public UsersResponseDTO updateUser (@PathVariable Long id, @RequestBody UserRequestDTO requestDTO){
            return userService.updateUsers(id, requestDTO);
        }


        @DeleteMapping("/delete/{userId}")
        public String deleteUser (@PathVariable Long userId){
            return userService.deleteUser(userId);
        }


    }

