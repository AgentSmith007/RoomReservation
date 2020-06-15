package com.booking.epam.controller;

import com.booking.epam.dto.FullUserDto;
import com.booking.epam.dto.UserDto;
import com.booking.epam.service.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(Principal principal, @PathVariable("id") UUID id) {
        UserDto userDto = new UserDto();
        userDto = service.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> findByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(service.getUserByName(name), HttpStatus.OK);
    }


    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, response = UserDto.class, message = "Create user")})
    public ResponseEntity<?> createUser(
            @ApiParam(value = "User dto", required = true) @RequestBody UserDto userDto) {
        UserDto user = service.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, response = UserDto.class, message = "Update user")})
    public ResponseEntity<?> updateUser(
            @ApiParam(value = "User dto", required = true) @RequestBody FullUserDto userDto) {
        return new ResponseEntity<>(service.updateUser(userDto), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUserById(Principal principal, @PathVariable("id") UUID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
