package com.example.demo.repository;

import com.example.demo.entity.ApplyBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyBookRepository extends JpaRepository<ApplyBookEntity, Long> {

}
