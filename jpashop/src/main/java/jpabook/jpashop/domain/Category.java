package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    @ManyToMany  // 다 대 다 관계 . 실무에서 쓰면 안된다.
    @JoinTable(name="category_item",
            joinColumns = @JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="item_id")
    ) // 중간 테이블 매핑. 다 대 다 관계이므로 중간 단계로 풀어야한다.
    private List<Item> items=new ArrayList<>();

    // 셀프로 양방향 연관관계 걸어둠.
    @ManyToOne(fetch =  FetchType.LAZY )
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // 연관관계 메서드//
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }
}
