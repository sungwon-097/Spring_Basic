package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded // Address.java의 Embeddable만 있어도 되긴하는데 두개다 쓴다.
    private Address address;

    @OneToMany(mappedBy = "member") // order 테이블에 있는 member_id가 연관관계의 주인이라는 뜻
        private List<Order> orders = new ArrayList<>(); // 가장 좋은 초기화방법. 절대 바꾸지 말것. hibernate가 관리하므로 그냥 냅둠.
}
