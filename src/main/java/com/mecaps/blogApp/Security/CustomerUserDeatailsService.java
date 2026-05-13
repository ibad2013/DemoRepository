/*
package com.mecaps.blogApp.Security;

import com.mecaps.blogApp.Exception.ResourcrsNotFoundException;
import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDeatailsService  implements UserDetailsService {
 private  final UsersRepository usersRepository;

    public CustomerUserDeatailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = usersRepository.findByUserName(username).orElseThrow(() -> new ResourcrsNotFoundException("User name not found " + username));
        return User
               .withUserDetails(users.getUserName())
               .password(users.getPassword())
               .roles(users.getRole())
               .build();
    }


}*/

package com.mecaps.blogApp.Security;

import com.mecaps.blogApp.Exception.ResourcrsNotFoundException;
import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.UsersRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDeatailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomerUserDeatailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Users users = usersRepository.findByUserName(username)
                .orElseThrow(() ->
                        new ResourcrsNotFoundException(
                                "User name not found " + username));

        return User
                .withUsername(users.getUserName())
                .password(users.getPassword())
                .roles(users.getRole())
                .build();
    }
}

