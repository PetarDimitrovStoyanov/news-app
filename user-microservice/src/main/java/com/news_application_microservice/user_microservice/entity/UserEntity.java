package com.news_application_microservice.user_microservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(columnDefinition = "LONGTEXT")
    private String picture;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<RoleEntity> roles;
}
