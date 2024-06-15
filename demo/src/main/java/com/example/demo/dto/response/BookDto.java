package com.example.demo.dto.response;


import com.example.demo.entity.BookEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookDto {
    private String book_id;
    private String writer;
    private String bookname;
    private String bookcover;
    private String isExist;
    private String bookdetail;
    private String booknumber;
    private String iscertification;
    private String isMajor;
    private String year;


/*
    public static BookDto bookDto(BookEntity book) {
        BookDto bookDto = new BookDto();
        bookDto.setBook_id(book.getBook_id());
        bookDto.setWriter(book.getWriter());
        bookDto.setBookname(book.getBookName());
        bookDto.setBookcover(book.getBookCover());
        bookDto.setIsExist(book.get());
        bookDto.setBookdetail(book.getBookDetail());
        bookDto.setBooknumber(book.getBookNumber());
        bookDto.setIscertification(book.get);
        bookDto.setIsMajor(book.getIsMajor());
        bookDto.setYear(book.getYear());
        return bookDto;
    }*/



}
