package spring_start.spring_start.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_start.spring_start.domain.Member;
import spring_start.spring_start.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

//껍데기 자동 완성!
class MemberServiceTest {

    //테스트할 객체 생성
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    //각 테스트 케이스가 한번 진행된 뒤 저장된 값 클리어
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    //회원가입 회원 등록 확인 테스트
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("안정민");

        //when
        Long saveId = memberService.join(member);


        //then
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    //회원가입 중복 회원은 예외 발생 테스트
    @Test
    public void 중복회원예외(){
        Member member1 = new Member();
        member1.setName("기기기");

        Member member2 = new Member();
        member2.setName("기기기");

        memberService.join(member1);
        /*assertThrows(IllegalStateException.class,()->memberService.join(member2));*/

        //예외 처리 메세지를 확인하고 싶으면
        IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("같은 이름의 회원이 이미 존재합니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}