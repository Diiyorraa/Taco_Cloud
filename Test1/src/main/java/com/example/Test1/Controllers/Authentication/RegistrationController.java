package com.example.Test1.Controllers.Authentication;
import com.example.Test1.DTO.Requests.RegistrationForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Test1.Repositories.UsersRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {


    private UsersRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(
            UsersRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "RegistrationForm";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}