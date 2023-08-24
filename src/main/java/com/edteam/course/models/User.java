package com.edteam.course.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {
    @JsonIgnore
    @Column(name = "password")
    @Setter
    private String password;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "lastname")
    @Getter @Setter
    private String lastName;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "phone")
    @Getter @Setter
    private String phone;

    @Column(name = "birthday")
    @Getter @Setter
    private Date birthday;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}
