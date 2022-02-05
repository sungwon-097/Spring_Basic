package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if (item.getId()==null){
            em.persist(item); // 처음에는 id가 없으므로 persist 한다. 신규로 먼저 등록
        }
        else{
            em.merge(item); // update 비슷한 것. 이미 디비에 등록된 걸 가져옴.
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class,id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i",Item.class)
                .getResultList();
    }
}
