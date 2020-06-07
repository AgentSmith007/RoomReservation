package com.booking.epam.controller;

import com.booking.epam.dto.HotelDto;
import com.booking.epam.dto.UserDto;
import com.booking.epam.entity.Hotel;
import com.booking.epam.service.HotelService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService service;

    @GetMapping
    public ResponseEntity<?> getAllHotels() {
        return new ResponseEntity<>(service.getAllHotels(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable("id") UUID id) {
        Hotel hotel = service.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, response = HotelDto.class, message = "Create hotel")})
    public ResponseEntity<?> createHotel(
            @ApiParam(value = "Hotel dto", required = true) @RequestBody HotelDto hotelDto) {
        HotelDto hotel = service.createHotel(hotelDto);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable("id") UUID id) {
        Hotel hotel = service.getHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/rooms")
    public ResponseEntity<?> getAllRoomsByHotel() {
        return new ResponseEntity<>("RESPONSE ALL HOTEL ROOMS LIST", HttpStatus.OK);
    }

    @GetMapping(value = "/listRooms")
    public ResponseEntity<?> getAllAvailableRooms() {
        return new ResponseEntity<>("RESPONSE ALL ROOMS LIST", HttpStatus.OK);
    }
}
