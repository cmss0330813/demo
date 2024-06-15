package com.example.demo.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ReviewEntity {

    @Id
    @GeneratedValue
    private Long Review_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name="book_id")
    private BookEntity book;

    private Long rating;

    private String contents;
}
