package com.edteam.course.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role extends BaseEntity {
    @Column(name = "name")
    @Setter
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "role")
    private Set<Permission> permissions;
}
