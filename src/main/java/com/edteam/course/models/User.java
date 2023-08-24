package com.edteam.course.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Entity
@Table(name = "user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

}
