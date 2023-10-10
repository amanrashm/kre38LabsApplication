package org.kre38Labs.Controllers;

import org.kre38Labs.Entity.Item;
import org.kre38Labs.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
@ComponentScan
@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemRepository itemRepository;
    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = itemRepository.save(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedItem.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedItem);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}