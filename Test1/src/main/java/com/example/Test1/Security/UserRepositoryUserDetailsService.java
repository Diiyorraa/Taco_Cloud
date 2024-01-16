package com.example.Test1.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.
        UserDetailsService;
import org.springframework.security.core.userdetails.
        UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Test1.Models.Users;
import com.example.Test1.Repositories.UsersRepository;

@Service
public class UserRepositoryUserDetailsService
        implements UserDetailsService {

    private UsersRepository userRepo;

    @Autowired
    public UserRepositoryUserDetailsService(UsersRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}