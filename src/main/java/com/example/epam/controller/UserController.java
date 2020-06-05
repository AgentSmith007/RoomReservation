package com.example.epam.controller;

import com.example.epam.component.UserComponent;
import com.example.epam.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserComponent bean;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(Principal principal) {
        UserDto userDto = new UserDto();
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
