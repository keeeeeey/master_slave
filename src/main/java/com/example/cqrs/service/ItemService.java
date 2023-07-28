package com.example.cqrs.service;

import com.example.cqrs.dto.ItemRequestDto;
import com.example.cqrs.dto.ItemResponseDto;
import com.example.cqrs.entity.Item;
import com.example.cqrs.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public ItemResponseDto findItemById(Long itemId) {
        Item findItem = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("존재하지 않은 아이디입니다."));
        return ItemResponseDto.from(findItem);
    }

    @Transactional
    public void saveItem(ItemRequestDto requestDto) {
        Item item = Item.from(requestDto);
        itemRepository.save(item);
    }
}
