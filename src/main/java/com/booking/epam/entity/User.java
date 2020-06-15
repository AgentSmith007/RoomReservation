package com.booking.epam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User extends BaseEntity {
    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "user_name")
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tl_users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

}
