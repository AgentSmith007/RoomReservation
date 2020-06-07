package com.booking.epam.repository;

import com.booking.epam.entity.Hotel;
import com.booking.epam.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, UUID> {

    @Override
    Iterable<Hotel> findAllById(Iterable<UUID> iterable);
}
