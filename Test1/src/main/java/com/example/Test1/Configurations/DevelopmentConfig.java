package com.example.Test1.Configurations;


import com.example.Test1.Models.Ingredients;
import com.example.Test1.Models.Users;
import com.example.Test1.Repositories.IngredientsRepository;
import com.example.Test1.Repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("!prod")
@Configuration

public class DevelopmentConfig {
    @Bean
    public CommandLineRunner dataLoader(IngredientsRepository repo, UsersRepository userRepo, PasswordEncoder encoder)
    {
        return  new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {


                userRepo.save(new Users("habuma", encoder.encode("password"),
                        "Craig Walls", "123 North Street", "Cross Roads", "TX",
                        "76227", "123-123-1234"));
            }
        };
    }


}
