package com.booking.epam.service;

import com.booking.epam.dto.UserDto;
import com.booking.epam.entity.User;
import com.booking.epam.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class UserService extends AbstractServiceDao<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Autowired
    private ValidatorService validator;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public User getUserById(UUID id) {
        return repository.findById(id).get();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto createUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        user.setPassword(encoder.encode(userDto.getPassword()));
        user = repository.save(user);
        return mapper.map(user, UserDto.class);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto updateUser(FullUserDto userDto) {
        User existedUser = findById(userDto.getId());
        if (userDto.getUserName().isBlank()) {
            existedUser.setUserName(userDto.getUserName());
        }
        if (userDto.getLogin().isBlank()) {
            existedUser.setLogin(userDto.getLogin());
        }
        if (userDto.getPassword().isBlank()) {
            existedUser.setPassword(encoder.encode(userDto.getPassword()));
        }
        if (userDto.getEmail().isBlank()) {
            existedUser.setEmail(userDto.getEmail());
        }
        if (userDto.getPhone().isBlank()) {
            existedUser.setPhone(userDto.getPhone());
        }
        existedUser = save(existedUser);
        return mapper.map(existedUser, UserDto.class);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(UUID id) {
        validator.validateUUID(id);
        User deleteUser = findById(id);
        if (deleteUser != null) {
            delete(deleteUser);
        }
    }
}
