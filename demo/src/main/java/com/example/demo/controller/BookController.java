package com.example.demo.controller;


import com.example.demo.entity.ApplyBookEntity;
import com.example.demo.entity.BookEntity;
import com.example.demo.service.ApplyBookService;
import com.example.demo.service.BookService;
import com.example.demo.response.ResponseVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    @Autowired
    private BookService bookService;
    private ApplyBookService applyBookService;
    private final WebClient.Builder webClientBuilder;

    private final int MAX_RESULTS = 10;




    //진짜 그냥 테스트
    @GetMapping("/api")
    public String test1() {
        return "이것은 테스트";
    }


    //저장
    @PostMapping("/test")
    public void save(@RequestBody BookEntity book) {
        System.out.println(book);
        bookService.save(book);
    }

    //get All
    //성공
    @GetMapping("/book/all")
    public List<BookEntity> book_getAll() {
        return bookService.getAll();
    }


    //get by id (id=book_id)
    //성공
    @GetMapping("/book/one{id}")    //1614877
    public BookEntity book_getById(@RequestParam(value = "book_id", defaultValue = "1614877",required = false) String string) {
        return bookService.getById(string);
    }

    @GetMapping("/book/two")    //1614877
    public BookEntity book_getitem() {
        return bookService.getById("1614877");
    }


    //학년별, 학과별은 컬럼과 메소드명이 좀 다름
    //-> db에 데이터 때려 넣으면서 달라짐
    //get by 학년
    @GetMapping("/book/grade{writer}")
    public List<BookEntity> book_getByWriter(@RequestParam(value = "writer", defaultValue = "4", required = false) String string) {
        return bookService.getByWriter(string);
    }

    //get by 학과
    @GetMapping("/book/dept{bookcover}")
    public List<BookEntity> book_getByBookCover(@RequestParam(value = "bookCover", defaultValue = "신소재공학부", required = false) String string) {
        return bookService.getByBookCover(string);
    }


    //전공 getALl
    //성공
    @GetMapping("/book/major/all")
    public List<BookEntity> major_getAll() {
        return bookService.getAll_major();
    }

    //일반 getALl
    //성공
    @GetMapping("/book/normal/all")
    public List<BookEntity> normal_getAll() {
        return bookService.getAll_normal();
    }

    //자격증 getALl
    //null로 나옴, 빈 배열
    @GetMapping("/book/certified/all")
    public List<BookEntity> certified_getAll() {
        return bookService.getAll_certified();
    }


    //--- 알라딘 ---//
    // 책 리스트 나열
    @GetMapping("/aladin/list")
    public List<BookEntity> showApiList(@RequestParam String data) throws JsonProcessingException {
        String apiKey = data;   //ttbcmss03302033001

        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey={apiKey}&QueryType=ItemNewAll&MaxResults=MAX_RESULTS&start=1&SearchTarget=Book&output=js&Version=20131101";
        String res = webClientBuilder.build()
                .get()
                .uri(apiUrl, apiKey, data)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        List<BookEntity> bookEntities = bookService.fetchListData(res , MAX_RESULTS);

        ResponseVo responseVo = new ResponseVo();

        if(res == null){
            responseVo.setUcd("99");
            responseVo.setMessage("실패");
        }
        else{
            responseVo.setUcd("00");
            responseVo.setMessage(res);
            System.out.println(ResponseEntity.ok(responseVo));
        }
        return bookEntities;
    }

    //--- 알라딘 ---//
    // 책 상세 정보
    @GetMapping("/aladin/info")
    public ResponseEntity<BookEntity> showBookInfo(@RequestParam String data, @RequestParam String itemId) throws JsonProcessingException {
        //String apiKey = data;   //ttbcmss03302033001
        //String id = itemId;

        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey={data}&itemIdType=ISBN&ItemId={itemId}&output=js&Version=20131101&OptResult=ratingInfo,reviewList";
        String res = webClientBuilder.build()
                .get()
                .uri(apiUrl, data, itemId)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        bookService.fetchData(res);

        ResponseVo responseVo = new ResponseVo();

        if(res == null){
            responseVo.setUcd("99");
            responseVo.setMessage("실패");
        }
        else{
            responseVo.setUcd("00");
            responseVo.setMessage(res);
        }
        return ResponseEntity.ok(bookService.fetchData(res));

    }

    @PostMapping("/apply")
    public Long ApplyBook(@RequestParam ApplyBookEntity applyBookEntity) {
        // isbn 정보 and 현재 로그인 중인 회원 id
        return applyBookService.saveApply(applyBookEntity);
    }




/*
// 특정 컨트롤러에만 CORS 적용하고 싶을때.
@Controller
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class customController {

	// 특정 메소드에만 CORS 적용 가능
    @GetMapping("/url")
    @CrossOrigin(origins = "*", methods = RequestMethod.GET)
    @ResponseBody
    public List<Object> findAll(){
        return service.getAll();
    }
}

 */

/*

    // 책 리스트 나열
    @GetMapping("/booklist")
    public ResponseEntity<ResponseVo> showApiList(@RequestParam("apikey") String data) {
        String apiKey = data;

        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey={apiKey}&QueryType=ItemNewAll&MaxResults=10&start=1&SearchTarget=Book&output=xml&Version=20131101";
        String res = webClientBuilder.build()
                .get()
                .uri(apiUrl, apiKey, data)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(res);

        ResponseVo responseVo = new ResponseVo();

        if(res == null){
            responseVo.setUcd("99");
            responseVo.setMessage("실패");
        }
        else{
            responseVo.setUcd("00");
            responseVo.setMessage(res);
        }
        return ResponseEntity.ok(responseVo);
    }

    // 책 상세 정보
    @GetMapping("/bookinfo")
    public ResponseEntity<ResponseVo> testApi() {
        String apiKey = "ttbcmss03302033001";   //ttbcmss03302033001
        String itemId = "9791193078174";

        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey={apiKey}&itemIdType=ISBN&ItemId={itemId}&output=xml&Version=20131101&OptResult=ebookList,usedList,reviewList";
        String res = webClientBuilder.build()
                .get()
                .uri(apiUrl, apiKey, itemId)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(res);

        ResponseVo responseVo = new ResponseVo();

        if(res == null){
            responseVo.setUcd("99");
            responseVo.setMessage("실패");
        }
        else{
            responseVo.setUcd("00");
            responseVo.setMessage(res);
        }
        return ResponseEntity.ok(responseVo);
    }
*/








}
