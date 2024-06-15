package com.example.demo.service;

import com.example.demo.entity.ApplyBookEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplyBookService {


    public Long saveApply(ApplyBookEntity applyBookEntity) {
        ApplyBookService applyBookService = new ApplyBookService();
        return applyBookService.saveApply(applyBookEntity);
    }
}
