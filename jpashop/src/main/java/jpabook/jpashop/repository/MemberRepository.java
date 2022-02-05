package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext  // JPA의 매니저를 자기가 주입해준다. 롬복으로 인해 이를 주석처리
    private final EntityManager em; // JPA 가 관리. EntityManger는 @Autowired가 안되지만 스프링부트 JPA가 그냥 인젝션되게 지원해줌.

//    public MemberRepository(EntityManager em){
//        this.em=em;
//    }

    public void save(Member member){
        em.persist(member); // Key : Value 로 저장되는데, Key값은 member의 pk 이다.
    }

    public Member findOne(Long id){
        return em.find(Member.class,id); // 타입, PK
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class) // JPQL, 반환타입, 테이블이 아닌 엔티티에서 가져옴
            .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name=:name",Member.class)
                .setParameter("name",name) // 위의 우측 name에 바인딩
                .getResultList();
    }
}