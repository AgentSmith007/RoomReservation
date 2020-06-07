package com.booking.epam.dto;

import com.booking.epam.entity.Hotel;
import com.booking.epam.entity.RoomType;
import com.booking.epam.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private int roomNumber;

    private RoomType type;

    private boolean reserved;

    private long price;

    private String description;

    private UUID hotel;

    private User visitor;
}
