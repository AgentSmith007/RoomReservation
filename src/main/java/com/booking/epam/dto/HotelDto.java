package com.booking.epam.dto;

import com.booking.epam.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto extends CommonIdDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String phone;

    private String email;

    private String description;
}
