package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long,Item> store = new HashMap<>();
    private static  long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        // 감싸줘서 반환해준다 이유는 원본에 변화를 안주기 위해서.
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        // 이렇게 직접 set 하는 것보다 DTO를 이용해서 하는게 중복이 생기더라도 더좋다
        // 추가 수정을 방지~ 의미의 명확성 증가~!.!
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }

}
