package com.example.epam.controller;


import com.example.epam.entity.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/room")
public class RoomController {

    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable("id") Long id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/{id}/reserve")
    public ResponseEntity<?> reserveRoomById(@PathVariable("id") Long id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/{id}/cancel")
    public ResponseEntity<?> cancelReserveRoomById(Principal principal, @PathVariable("id") Long id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }


}
