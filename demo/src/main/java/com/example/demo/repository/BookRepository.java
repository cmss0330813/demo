package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String>, BookRepositoryCustom {
    List<BookEntity> findByMajor();
    List<BookEntity> findByNormal();
    List<BookEntity> findByCertified();

    
    //학년별 조회
    List<BookEntity> findByWriter(@RequestParam("writer") String string);

    
    //학과별 조회
    List<BookEntity> findByBookCover(@RequestParam("bookcover") String string);


}
