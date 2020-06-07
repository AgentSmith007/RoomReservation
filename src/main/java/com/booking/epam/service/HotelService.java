package com.booking.epam.service;

import com.booking.epam.dto.HotelDto;
import com.booking.epam.entity.Hotel;
import com.booking.epam.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class HotelService {
    @Autowired
    private HotelRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    public Hotel getHotelById(UUID id) {
        return repository.findById(id).get();
    }

    @Transactional
    public List<Hotel> getAllHotels() {
        return (List<Hotel>) repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = mapper.map(hotelDto, Hotel.class);
        hotel = repository.save(hotel);
        return mapper.map(hotel, HotelDto.class);
    }


}
