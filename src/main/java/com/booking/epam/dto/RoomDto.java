package com.booking.epam.dto;

import com.booking.epam.entity.User;
import com.booking.epam.entity.enums.RoomType;
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
public class RoomDto extends CommonIdDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private int roomNumber;

    private RoomType type;

    private boolean reserved;

    private String startReservedDate;

    private String endReservedDate;

    private long price;

    private String description;

    private UUID hotel;

    private UUID visitor;
}
