package com.example.Test1.Controllers.Authentication;

import com.example.Test1.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UsersRepository userRepo;

    @GetMapping
    public String login() {

        return "login";
    }
}