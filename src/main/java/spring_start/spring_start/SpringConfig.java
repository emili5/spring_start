package spring_start.spring_start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_start.spring_start.repository.MemberRepository;
import spring_start.spring_start.repository.MemoryMemberRepository;
import spring_start.spring_start.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }


}
