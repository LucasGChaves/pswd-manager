package com.example.app.domain.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="Vault", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "plataform_id"})})
public class Vault {

    public Vault() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id",  updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="username")
    private String username;

    @Column(name = "password", length = 512, nullable = false)
    private String password;

    @Column(name = "cipher_text_64", columnDefinition = "text", nullable = false)
    private String cipherText64;

    @Column(name = "nonce_64", columnDefinition = "text", nullable = false)
    private String nonce64;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name="updated_at", nullable = false)
    private Instant updatedAt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public Platform getPlatform() {
        return platform;
    }
}
