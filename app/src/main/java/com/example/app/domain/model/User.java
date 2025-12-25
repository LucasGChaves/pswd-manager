package com.example.app.domain.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="Users", uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", nullable = false, unique = true, length = 11)
    private UUID id;

    @Column(name = "username", length = 20, nullable = false)
    private  String username;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "email", length = 35, nullable = false)
    private String email;

    @Column(name = "cellphone", length = 16, nullable = false)
    private String cellphone;

    @Column(name = "master_password", length = 512, nullable = false)
    private String masterPassword;

    @Column(name = "salt", nullable = false, length = 64)
    private String salt;

    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name="updated_at", nullable = false)
    private Instant updatedAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterPassword(String masterPasswordHash) {
        this.masterPassword = masterPasswordHash;
    }
}
