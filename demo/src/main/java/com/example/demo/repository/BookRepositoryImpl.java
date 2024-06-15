package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.QBookEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepositoryCustom {

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;
    private final QBookEntity book = QBookEntity.bookEntity;


    public List<BookEntity> findById(@RequestParam("book_id") String string) {
        return jpaQueryFactory.selectFrom(book)
                .where(book.book_id.eq(string))
                .fetch();
    }

    public List<BookEntity> findById1() {
        return jpaQueryFactory.selectFrom(book)
                .where(book.book_id.eq("1614877"))
                .fetch();
    }



    //전공 전체 조회
    @Override
    public List<BookEntity> findByMajor() {
        //BookDto bookDto = BookDto.bookDto(book);
        return jpaQueryFactory.selectFrom(book)
                .where(book.isMajor.eq("T"))
                .fetch();
    }

    //일반 전체 조회
    //db에 컬럼이 없네ㅎㅎ
    @Override
    public List<BookEntity> findByNormal() {
        return jpaQueryFactory.selectFrom(book)
                .where(book.isMajor.eq("F"))
                .fetch();
    }

    //자격증 전체 조회
    @Override
    public List<BookEntity> findByCertified() {
        return jpaQueryFactory.selectFrom(book)
                .where(book.bookName.contains("자격증"))
                .fetch();
    }


    //학년별 조회
    @Override
    public List<BookEntity> findByWriter(@RequestParam("writer") String string) {
        return jpaQueryFactory.selectFrom(book)
                .where(book.writer.eq(string))
                .fetch();
    }

    //학과별 조회
    @Override
    public List<BookEntity> findByBookCover(@RequestParam("bookcover") String string) {
        return jpaQueryFactory.selectFrom(book)
                .where(book.bookCover.eq(string))
                .fetch();
    }
}
