package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookService {
    void save(BookEntity book);

    //전체 도서 조회
    List<BookEntity> getAll();

    //상세 조회
    BookEntity getById(String string);
    BookEntity getById1();


    //학년별 조회
    List<BookEntity> getByWriter(@RequestParam("writer") String string);


    //학과별 조회
    List<BookEntity> getByBookCover(@RequestParam("writer") String string);


    //전공 조회
    List<BookEntity> getAll_major();

    //일반 조회
    List<BookEntity> getAll_normal();

    //자격증 조회
    List<BookEntity> getAll_certified();


    List<BookEntity> fetchListData(String res, int max) throws JsonProcessingException;
    BookEntity fetchData(String res) throws JsonProcessingException;

}
