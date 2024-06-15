package com.example.demo.dto.response;

import com.example.demo.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookListDto {

    String title;
    String isbn;
    String cover;
    String author;
    String description;
    String categoryName;
    int ratingScore;


    public BookEntity modelMapper() {
        return null;
    }
}
