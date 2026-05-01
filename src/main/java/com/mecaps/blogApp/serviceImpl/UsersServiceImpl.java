package com.mecaps.blogApp.serviceImpl;

import com.mecaps.blogApp.Exception.ResourcrsNotFoundException;
import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.UsersRepository;
import com.mecaps.blogApp.requestDTO.UserRequestDTO;
import com.mecaps.blogApp.responseDTO.UsersResponseDTO;
import com.mecaps.blogApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UserService {


    private UsersRepository usersRepository;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }



    @Override
    public UsersResponseDTO createUsers(UserRequestDTO request) {


        Users users = new Users();

        users.setUserName(request.getUserName());
        users.setEmail(request.getEmail());
        users.setPassword(request.getPassword());
        users.setRole("NormalUser");

        Users save = usersRepository.save(users);

        return  new UsersResponseDTO(save);


    }




    @Override
    public UsersResponseDTO getById(Long id) {

        Users users = usersRepository.findById(id).orElseThrow(
                () -> new ResourcrsNotFoundException("User id not found : " + id));
        return new UsersResponseDTO(users);
    }



    @Override
    public List<UsersResponseDTO> getAll() {

        List<Users> all = usersRepository.findAll();
            if(all.isEmpty())
                throw  new ResourcrsNotFoundException("No user exist in db");
        return all.stream().map(UsersResponseDTO::new).toList(); // same work (loops)


//        List<UsersResponseDTO> allUser = new ArrayList<>();
//        for (Users user : all){
//
//            UsersResponseDTO usersResponseDTO = new UsersResponseDTO(user);
//            allUser.add(usersResponseDTO);
//
//        }
//        return allUser;


    }



    @Override
    public UsersResponseDTO updateUsers(Long id, UserRequestDTO request) {

        Users users = usersRepository.findById(id).orElseThrow(
                () -> new ResourcrsNotFoundException("User id not found : " + id));

        // .isEmpty() or .isBlank()

        if (request.getUserName() != null && !request.getUserName().isBlank())
            users.setUserName(request.getUserName());


        if(request.getEmail() != null && !request.getEmail().isBlank())
            users.setEmail(request.getEmail());

        if (request.getPassword() != null && ! request.getPassword().isBlank())
            users.setPassword(request.getPassword());


        Users save = usersRepository.save(users);

        return new UsersResponseDTO(save);
    }




    @Override
    public String deleteUser(Long id) {

        Users users = usersRepository.findById(id).orElseThrow(
                () -> new ResourcrsNotFoundException("User id not found : " + id));


        usersRepository.delete(users);

        return "User Deleted Successfully!";
    }




}
