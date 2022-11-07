package com.naidiuk.shops.repository;

import com.naidiuk.shops.entity.Shop;

import java.util.List;

public interface ShopRepository {
    Shop save(Shop shop);
    Shop deleteById(Long id);
    List<Shop> getAll();
    Shop findById(Long id);
    Shop update(Shop shopForUpdate);
}
