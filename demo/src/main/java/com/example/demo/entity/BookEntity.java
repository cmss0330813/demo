package com.example.demo.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class BookEntity {

    @Id
    private String book_id;

    private String writer;

    private String bookName;

    private String bookCover;

    private String bookDetail;


    private String bookNumber;

    private String genre;

    private String isExist;

    private String isStored;


    private String isMajor;

    private String isCertification;
}
