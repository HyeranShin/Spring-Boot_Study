package com.hyeran.seminar8.api;

import com.hyeran.seminar8.domain.Item;
import com.hyeran.seminar8.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class TestController {

    //JPA
    private final ItemRepository itemRepository;

    public TestController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("jpa")
    public ResponseEntity jpaTest() {
        try {
            final Item item = new Item(1, "test");
            log.info("---------------jpa insert data---------------");
            itemRepository.save(item);
            log.info("---------------jpa findOne data---------------");
            Optional<Item> content = itemRepository.findById(1);
            log.info(content.toString());
            log.info("---------------jpa findAll data---------------");
            Iterable<Item> contentList = itemRepository.findAll();
            log.info(contentList.toString());
            log.info("---------------jpa delete data---------------");
            itemRepository.delete(item);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
