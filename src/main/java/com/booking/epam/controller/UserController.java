package com.booking.epam.controller;

import com.booking.epam.dto.UserDto;
import com.booking.epam.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(Principal principal, @PathVariable("id") UUID id) {
        UserDto userDto = new UserDto();
        userDto.setUserName("HIP HIP HURAAA NAME!");
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>("RESPONSE ALL USERS LIST", HttpStatus.OK);
    }


    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, response = UserDto.class, message = "Create user")})
    public ResponseEntity<?> createUser(
            @ApiParam(value = "User dto", required = true) @RequestBody UserDto userDto) {
        UserDto user = service.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUserById(Principal principal, @PathVariable("id") UUID id) {
        UserDto userDto = new UserDto();
        userDto.setUserName("HIP HIP HURAAA NAME!");
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }


}
