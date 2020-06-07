package com.booking.epam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "room")
public class Room extends BaseEntity {

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Column(name = "reserved")
    private boolean reserved;

    @Column(name = "start_reserved_date")
    private long startReservedDate;

    @Column(name = "end_reserved_date")
    private long endReservedDate;

    @Column(name = "price")
    private long price;

    @Column(name = "description")
    private String description;

    @Column(name = "hotel_id")
    private UUID hotel;

    @Column(name = "visitor_id")
    private User visitor;

}