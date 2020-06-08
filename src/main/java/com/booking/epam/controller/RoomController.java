package com.booking.epam.controller;


import com.booking.epam.entity.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @GetMapping//возвращать румы отеля или все вообще?
    public ResponseEntity<?> getAllRooms(@PathVariable("id") UUID id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable("id") UUID id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable("id") UUID id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    //TODO ROLE for admin only
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createRoom(@PathVariable("id") UUID id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    //корректно?
    @PostMapping(value = "/{id}/reserve")
    public ResponseEntity<?> reserveRoomById(Principal principal, @PathVariable("id") UUID id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    //корректно?
    @PostMapping(value = "/{id}/cancel")
    public ResponseEntity<?> cancelReserveRoomById(Principal principal, @PathVariable("id") UUID id) {
        Room room = new Room();
        return new ResponseEntity<>(room, HttpStatus.OK);
    }


}
