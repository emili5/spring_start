package spring_start.spring_start.repository;

import spring_start.spring_start.domain.Member;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//member이름 저장
    Optional<Member> findById(Long id); //아무 값이 없을 경우 null을 반환하지 않게 함
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 회원 이름 반환

}
