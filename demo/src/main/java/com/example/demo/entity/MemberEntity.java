package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class MemberEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long member_id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String department;

    private Long grade;

    private String genre;

}
