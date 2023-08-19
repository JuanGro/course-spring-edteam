package com.edteam.course.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {

    @JsonIgnore
    @Column(name = "password")
    @Getter @Setter
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

    public User() {

    }

    public User(long id, String name, String lastName, String phone, Date birthday) {
        setId(id);
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.birthday = birthday;
    }
}
