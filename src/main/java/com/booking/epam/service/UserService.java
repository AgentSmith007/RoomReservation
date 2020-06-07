package com.booking.epam.service;

import com.booking.epam.dto.UserDto;
import com.booking.epam.entity.User;
import com.booking.epam.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    public User getUserById(UUID id) {
        return repository.findById(id).get();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto createUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        user = repository.save(user);
        return mapper.map(user, UserDto.class);
    }
}
