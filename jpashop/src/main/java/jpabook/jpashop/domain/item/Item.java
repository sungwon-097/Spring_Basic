package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 한 테이블에 다 때려박음
@DiscriminatorColumn(name="dtype")
@Getter
@Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity; // 재고 수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비지니스 로직==//
    // 데이터가 가지고 있는 쪽에 비지니스 메서드가 있는 것이 좋다. Item 엔티티에 재고 정보가 있으므로, Service 쪽이 아니라 여기서 로직 구현한다.
    // 객체지향적 //

    /**
     * 재고 증가
     */

    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /**
     * 재고 감소
     */

    public void removeStock(int quantity){
        int restStock = this.stockQuantity -=quantity;
        if (restStock <0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
