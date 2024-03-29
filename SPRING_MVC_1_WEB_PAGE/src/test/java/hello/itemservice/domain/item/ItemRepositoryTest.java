package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        //g
        Item item = new Item("itemA", 1000, 10);
        //t
        Item saveItem = itemRepository.save(item);
        //w
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll(){
        Item item1 = new Item("item1", 1000, 10);
        Item item2 = new Item("item2", 2000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //w
        List<Item> result = itemRepository.findAll();

        //t
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1,item2);
    }

    @Test
    void updateItem(){
        Item item = new Item("item1", 10000, 10);
        Item saveItem = itemRepository.save(item);
        long saveItemId = saveItem.getId();
        //w
        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(saveItemId,updateParam);

        //t
        Item findItem = itemRepository.findById(saveItemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
}