package spring_start.spring_start.service;

import spring_start.spring_start.domain.Member;
import spring_start.spring_start.repository.MemberRepository;
import spring_start.spring_start.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//해당 서비스의 테스트를 만들고 싶으면 Ctrl+Shift+T!
public class MemberService {

    private final MemberRepository memberRepository;

    //service를 실행할 때마다 레포지토리를 생성해서 같은 레포지토리에 대해 테스트를 진행하도록 한다.-> MemberService입장에서는 외부에서 생성된 레포지토리를 받음: 의존성 주입(Dependency Injection)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*회원가입*/
    public Long join(Member member){

/*        Optional<Member> result = memberRepository.findByName(member.getName());//Optional로 감쌌기 때문에 null을 따질 필요 없고 바로 isPresent()로 확인해주면 됨
        result.ifPresent(m->{
            throw new IllegalStateException("같은 이름의 회원이 이미 존재합니다.");
        });*/


        //조건: 같은 이름을 가진 중복회원은 등록할 수 없다
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    //findByName이 있으면 Extract 메서드로 따로 뽑음(Ctrl+Alt+M)
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //Optional을 따로 쓰지 않고 바로 씀
        .ifPresent(m-> {
            throw new IllegalStateException("같은 이름의 회원이 이미 존재합니다.");
        });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
