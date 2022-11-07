package com.naidiuk.shops.controller;

import com.naidiuk.shops.dto.ShopDto;
import com.naidiuk.shops.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ShopDto shopDto) {
        ShopDto savedShopDto = shopService.save(shopDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShopDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ShopDto deletedShopDto = shopService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedShopDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ShopDto foundShopDto = shopService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundShopDto);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ShopDto shopDtoForUpdate) {
        ShopDto updatedShopDto = shopService.update(shopDtoForUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(updatedShopDto);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ShopDto> shopsDto = shopService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(shopsDto);
    }
}
