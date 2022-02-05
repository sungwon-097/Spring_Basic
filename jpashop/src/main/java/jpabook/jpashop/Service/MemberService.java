package jpabook.jpashop.Service;

import jpabook.jpashop.controller.MemberController;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // 스프링의 transactional을 사용하자!
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional(readOnly = true) // 데이터 변경은 여기안에서 이뤄져야함. 조회의 경우, readOnly = true로 하여 리소스 아낌
//@AllArgsConstructor // 생정자 주입을 만들어줌
@RequiredArgsConstructor // final 이 있는 필드만 가지고 생성자 주입을 만들어줌
public class MemberService {

    private final MemberRepository memberRepository; // 컴파일 시점에 체크를 할 수 있으므로 final 넣자. 생성자에서 this.memberRepository = memberRepository를 해야 빨간줄 안생김
//
//    //@Autowired // 생성자 주입. 어차피 맨 처음에 생성되고나서 이후로 변경하지 않으므로 세터주입할 필요가 없음. 의존관계도 명확히 알 수 있음.
//    // 생성자 하나면 @Autowired 생략 가능
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 회원 가입
     */

    @Transactional // readOnly=true가 디폴트이므로 join은 데이터 변경 메소드이므로 따로 설정한다.
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    } // 둘이 동시에 가입하면??? 문제생기므로, 데이터베이스에 member의 name을 유니크제약조건으로 걸어둔다.

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 단건 조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
