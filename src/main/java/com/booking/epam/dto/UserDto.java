package com.booking.epam.dto;

import com.booking.epam.entity.Role;
import com.booking.epam.entity.enums.RoleType;
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
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;

    private String password;

    private String email;

    private String phone;

    private String userName;

    private Set<Role> roles;
}
