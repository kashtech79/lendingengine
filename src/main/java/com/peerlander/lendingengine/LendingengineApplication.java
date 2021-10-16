package com.peerlander.lendingengine;

import com.peerlander.lendingengine.domain.model.User;
import com.peerlander.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingengineApplication  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(LendingengineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(1, "Kash", "Saeed", 27, "Software Developer"));
        userRepository.save(new User(2, "Abdullah", "Saeed", 11, "Python Developer"));
        userRepository.save(new User(3, "Seeschon", "Ahmed", 41, "Accountant"));
    }
}
