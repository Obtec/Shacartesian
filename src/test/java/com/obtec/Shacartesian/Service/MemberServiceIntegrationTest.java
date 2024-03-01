package com.obtec.Shacartesian.Service;

import java.util.*;

import com.obtec.Shacartesian.domain.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;

    @Test
    void testJoin1() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long id = memberService.join(member);

        //then
        Optional<Member> result = memberService.findOne(id);
        Assertions.assertEquals(member.getName(), result.get().getName());
    }

    @Test
    void testJoin2() {
        //given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        //then
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2) );
    }

    @Test
    void testValidateDuplicateMember() {
    }

    @Test
    void testFindMembers() {
    }

    @Test
    void testFindOne() {
    }
}