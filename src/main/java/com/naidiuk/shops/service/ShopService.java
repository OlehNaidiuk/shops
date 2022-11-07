package com.naidiuk.shops.service;

import com.naidiuk.shops.dto.ShopDto;

import java.util.List;

public interface ShopService {
    ShopDto save(ShopDto shopDto);
    ShopDto findById(Long id);
    ShopDto deleteById(Long id);
    ShopDto update(ShopDto shopDtoForUpdate);
    List<ShopDto> getAll();
}
