package com.naidiuk.shops.repository;

import com.naidiuk.shops.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShopRepositoryImpl implements ShopRepository {
    private final Map<Long, Shop> shopDB = new HashMap<>();

    @Override
    public Shop save(Shop shop) {
        shopDB.put(shop.getId(), shop);
        return shopDB.get(shop.getId());
    }

    @Override
    public Shop deleteById(Long id) {
        return shopDB.remove(id);
    }

    @Override
    public List<Shop> getAll() {
        return new ArrayList<>(shopDB.values());
    }

    @Override
    public Shop findById(Long id) {
        return shopDB.get(id);
    }

    @Override
    public Shop update(Shop shopForUpdate) {
        return save(shopForUpdate);
    }
}
