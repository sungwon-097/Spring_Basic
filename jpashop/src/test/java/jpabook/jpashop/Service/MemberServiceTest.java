package jpabook.jpashop.Service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // Junit 을 스프링러너와 같이 실행
@SpringBootTest // 스프링 부트를 띄운 상태로 테스트한다.
@Transactional // 롤백하므로 영속성 컨텍스트를 플러쉬하지않아서 insert문이 날라가지 않는다. 서비스나 레포지토리는 롤백되지 않는다.
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    //@Autowired
    //EntityManager em;

    @Test
    //@Rollback(false)
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("Kim");

        //when
        Long savedId = memberService.join(member);

        //then
        // em.flush(); // 영속성 반영
        assertEquals(member,memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class) // 예외가 터져서 나간애가 해당 파라미터 예외면 된다는 뜻
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);

        // 위의 expected 파라미터로 예외처리 구문 필요없어짐
//        try {
//            memberService.join(member2); // 예외가 발생해야한다. 발생하면 테스트 나가짐.
//        } catch(IllegalStateException e){
//            return;
//        }
        memberService.join(member2);

        //then
        fail("예외가 발생해야 합니다."); // 코드가 돌다가 여기로 오면 안된다. 즉 fail로 도착하므로 테스트실패가 된다.
    }
}