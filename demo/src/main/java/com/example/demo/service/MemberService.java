package com.example.demo.service;

import com.example.demo.entity.MemberEntity;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService /*implements UserDetailsService*/ {

    private final MemberRepository memberRepository;

    @Transactional
    public boolean register(MemberEntity member) {
        // findByUsername
        MemberEntity memberEntity = memberRepository.existsByUserName(member.getUserName());
        if(memberEntity != null) {
            memberRepository.save(member);
            memberRepository.flush();
            return true;
        }
        return false;
    }

    public boolean login(MemberEntity member) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(member.getMember_id());

        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get();
            if (member.getUserName().equals(memberEntity.getUserName()) &&
                    member.getPassword().equals(memberEntity.getPassword())) {
                return true;
            }
        }
        return false;
    }

}
