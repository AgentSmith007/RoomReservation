package com.booking.epam.entity;

import com.booking.epam.entity.enums.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "role")
public class Role extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID role_id;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public Role(RoleType role) {
        this.role = role;
    }
}
