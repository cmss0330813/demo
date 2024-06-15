package com.example.demo.controller;

import com.example.demo.entity.MemberEntity;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/hello")
    public void print() {
        System.out.println("hello");
    }

    // 회원가입
    @PostMapping("/registerProc")
    public boolean registerProc(@RequestBody MemberEntity memberEntity) {
        return memberService.register(memberEntity);
    }

    // 로그인
    @PostMapping("/login")
    public boolean login(@RequestBody MemberEntity memberEntity) {
        return memberService.login(memberEntity);
    }

}
