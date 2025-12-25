package com.example.app.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="Roles")
public class Role {

    public Role() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;
}
