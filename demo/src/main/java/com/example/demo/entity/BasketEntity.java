package com.example.demo.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class BasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basket_id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
}
