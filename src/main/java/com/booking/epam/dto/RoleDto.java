package com.booking.epam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends CommonIdDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String phone;

    private String email;

    private String description;
}
