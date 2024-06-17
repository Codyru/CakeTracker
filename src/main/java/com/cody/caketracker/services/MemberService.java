package com.cody.caketracker.services;

import com.cody.caketracker.models.Member;
import com.cody.caketracker.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(Member member) throws Exception {
        if (member.getAge() < 18) {
            throw new Exception("Member must be at least 18 years old");
        }
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public List<Member> getSortedMembersByBirthday() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .sorted((m1, m2) -> {
                    LocalDate today = LocalDate.now();
                    LocalDate nextBirthday1 = m1.getBirthDate().withYear(today.getYear());
                    LocalDate nextBirthday2 = m2.getBirthDate().withYear(today.getYear());

                    if (nextBirthday1.isBefore(today)) {
                        nextBirthday1 = nextBirthday1.plusYears(1);
                    }
                    if (nextBirthday2.isBefore(today)) {
                        nextBirthday2 = nextBirthday2.plusYears(1);
                    }

                    return nextBirthday1.compareTo(nextBirthday2);
                })
                .collect(Collectors.toList());
    }
}
