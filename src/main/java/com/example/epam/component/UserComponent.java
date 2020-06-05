package com.example.epam.component;

import com.example.epam.entity.User;
import com.example.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    @Autowired
    UserRepository repository;

    public User getUserById(long id) {
        return repository.findById(id).get();
    }
}
