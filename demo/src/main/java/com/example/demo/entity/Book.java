/*

package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String book_id;

    @Column
    private String writer;
    @Column
    private String bookname;
    @Column
    private String bookcover;
    @Column
    private String isExist;
    @Column
    private String bookdetail;
    @Column
    private String booknumber;
    @Column
    private String iscertification;
    @Column
    private String isMajor;
    @Column
    private String year;

}



*/
/*
book_id(도서 ID) --엑셀에 있는 id 그대로 쓸거같습니당
writer(작가) --알라딘에서 추가예정
bookname(도서명)
bookcover(표지)
isExist(청구기호)
bookdetail(도서 한줄소개) --알라딘에서 추가예정
booknumber(isbn)
genre(장르)
iscertification(자격증)
isStored(서가에 없는 도서 페이지에서 사용/ 그 외 페이지에서는 사용X)
ismajor(전공) -- 학과
year(년도) -- 한 sql 19,20,21 다 넣을거같은데 혹시 이상하면 말해주세용 수정하겠습니당
year는 sql에 없어서 제가 따로 추가했습니당

 */
