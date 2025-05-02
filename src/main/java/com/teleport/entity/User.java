package com.teleport.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private Long id;

    @Column(name= "user_name")
    private String username;

    @Column(name= "user_email")
    private String email;
}
