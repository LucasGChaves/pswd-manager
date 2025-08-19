package com.example.app.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name="Users", uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "username", length = 20, nullable = false)
    private  String username;

    @Column(name = "email", length = 35, nullable = false)
    private String email;

    @Column(name = "cellphone", length = 16, nullable = false)
    private String cellphone;

    @Column(name = "master_password", length = 50, nullable = false)
    private String masterPassword;

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

    public String getMasterPassword() {
        return masterPassword;
    }
}
