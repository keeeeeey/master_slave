package com.example.cqrs.controller;

import com.example.cqrs.dto.ItemRequestDto;
import com.example.cqrs.dto.ItemResponseDto;
import com.example.cqrs.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> findItemByID(@PathVariable(name = "itemId") Long itemId) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findItemById(itemId));
    }

    @PostMapping
    public ResponseEntity<String> saveItem(@RequestBody ItemRequestDto requestDto) {
        itemService.saveItem(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }
}
