package com.example.demo.repository;

import com.example.demo.entity.BookEntity;

import java.util.List;

public interface BookRepositoryCustom {
    List<BookEntity> findByMajor();
    List<BookEntity> findByNormal();
    List<BookEntity> findByCertified();


    //학년별 조회
    List<BookEntity> findByWriter(String string);

    //학과별 조회
    List<BookEntity> findByBookCover(String string);
}
