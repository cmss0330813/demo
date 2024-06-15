package com.example.demo.service;


import com.example.demo.dto.response.BookListDto;

import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {
    private ModelMapper modelMapper;

    @Autowired
    private BookRepository repository;

    public BookServiceImp(BookRepository bookRepository) {
        this.repository = bookRepository;
    }


    @Override
    public void save(BookEntity book) {
        repository.save(book);
    }


    //전체 조회
    @Override
    public List<BookEntity> getAll() {
        return repository.findAll();
    }


    //상세 조회
    @Override
    public BookEntity getById(@RequestParam("book_id") String string) {
        Optional<BookEntity> result = repository.findById(string);
        BookEntity book = result.orElseThrow();
          return book;
    }

    @Override
    public BookEntity getById1() {
        Optional<BookEntity> result = repository.findById("1614877");
        BookEntity book = result.orElseThrow();
        return book;
    }

    //학년별 조회
    @Override
    public List<BookEntity> getByWriter(@RequestParam("writer") String string) {
        List<BookEntity> result = repository.findById(string).stream().toList();
        return result;
    }

    //학과별 조회
    @Override
    public List<BookEntity> getByBookCover(@RequestParam("bookcover") String string) {
        List<BookEntity> result = repository.findById(string).stream().toList();
        ;
        return result;
    }

    //전공 조회
    @Override
    public List<BookEntity> getAll_major() {
        return repository.findByMajor();
    }

    //일반 조회
    @Override
    public List<BookEntity> getAll_normal() {
        return repository.findByNormal();
    }


    //자격증 조회
    @Override
    public List<BookEntity> getAll_certified() {
        return repository.findByCertified();
    }




    @Override
        public List<BookEntity> fetchListData(String res, int max) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(res);
            List<BookEntity> bookEntities = new ArrayList<>();

            if (rootNode != null && rootNode.has("item")) {
                JsonNode itemsNode = rootNode.get("item");
                int itemCount = itemsNode.size();
                int limit = Math.min(max, itemCount);

                for (int i = 0; i < limit; i++) {
                    JsonNode bookNode = itemsNode.get(i);

                    BookListDto bookListDto = new BookListDto();
                    bookListDto.setTitle(bookNode.path("title").asText(null));
                    bookListDto.setIsbn(bookNode.path("isbn13").asText(null));
                    bookListDto.setCover(bookNode.path("cover").asText(null));
                    bookListDto.setAuthor(bookNode.path("author").asText(null));
                    bookListDto.setDescription(bookNode.path("description").asText(null));
                    bookListDto.setCategoryName(bookNode.path("categoryName").asText(null));

                    JsonNode subInfoNode = bookNode.path("subInfo").path("ratingInfo");
                    if (!subInfoNode.isMissingNode()) {
                        bookListDto.setRatingScore(subInfoNode.path("ratingScore").asInt(0));
                    }

                    bookEntities.add(bookListDto.modelMapper());
                }
            }

            return bookEntities;

    }

    //@Override
    public BookEntity fetchData(String res) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(res);

        BookListDto bookListDto = new BookListDto();

        JsonNode itemNode = rootNode.path("item").path(0);

        if (!itemNode.isMissingNode()) {
            bookListDto.setTitle(itemNode.path("title").asText(null));
            bookListDto.setIsbn(itemNode.path("isbn13").asText(null));
            bookListDto.setCover(itemNode.path("cover").asText(null));
            bookListDto.setAuthor(itemNode.path("author").asText(null));
            bookListDto.setDescription(itemNode.path("description").asText(null));
            bookListDto.setCategoryName(itemNode.path("categoryName").asText(null));

            JsonNode subInfoNode = itemNode.path("subInfo").path("ratingInfo");
            if (!subInfoNode.isMissingNode()) {
                bookListDto.setRatingScore(subInfoNode.path("ratingScore").asInt(0));
            }
        }

        return bookListDto.modelMapper();
    }
}
