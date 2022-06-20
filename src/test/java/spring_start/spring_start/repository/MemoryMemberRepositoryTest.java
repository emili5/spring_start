package spring_start.spring_start.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_start.spring_start.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //각 테스트 케이스가 한번 진행된 뒤 저장된 값 클리어
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("안정민");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();//Optional에서 값을 꺼낼 때는 get()으로 꺼낼 수 있음
//        Assertions.assertEquals(member,result);// 기대하는 값과 실제 값이 같은지 확인
        assertThat(member).isEqualTo(result);//이렇게 더 간단하게 쓸 수도 있음

    }

    @Test
    public void findByName(){
        Member member1 = new Member(); //shift+F6으로 같은 변수이름 한번에 변경가능
        member1.setName("기기기");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("구구구");
        repository.save(member2);

        Member result = repository.findByName("기기기").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member(); //shift+F6으로 같은 변수이름 한번에 변경가능
        member1.setName("기기기");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("구구구");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
