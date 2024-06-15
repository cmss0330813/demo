package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.QueryParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class ApiController {
    private Map queryParameter;
    private Map.Entry entry;
    private StringBuilder sb = new StringBuilder();


    @GetMapping("/api/signin")
    public String loginTest(@RequestBody Map<String, String> data) {
        log.info("Received data: {}", data);

        // 필요한 경우 StringBuilder를 사용하여 응답을 생성할 수 있습니다.
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    @GetMapping("/api/signup")
    public String signupTest(@RequestBody Map<String, String> data) {
        log.info("Received data: {}", data);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }


/*
    @GetMapping("/majorList")
    public Map<String, String > list_major() {
        //Map<String, String> map1 =
       // return "majorList";
    }

    @GetMapping("/majordetail")
    public Map<String, String > detail_major() {
        Map<String, String> map1 =
        return "major";
    }
*/

    @GetMapping("/normalList")
    public String list_normal() {
        return "normalList";
    }

    @GetMapping("/normaldetail")
    public String detail_normal() {
        return "normal";
    }

    @GetMapping("/certificationList")
    public String list_certification() {
        return "certificationList";
    }

    @GetMapping("/certificationdetail")
    public String detail_certification() {
        return "certification";
    }



    @GetMapping("/applyBookList")
    public String list_apply() {
        return "apply";
    }


    @GetMapping("/applyBookDetail")
    public String detail_apply() {
        return "apply_detail";
    }



}
