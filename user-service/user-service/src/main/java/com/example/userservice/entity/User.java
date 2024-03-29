package com.example.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
}
