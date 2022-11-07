package com.naidiuk.shops.mapper;

import com.naidiuk.shops.dto.ShopDto;
import com.naidiuk.shops.entity.Shop;

public class ShopMapper {

    private ShopMapper() {
    }

    public static ShopDto transformToDto(Shop shop) {
        return ShopDto.builder()
                .id(shop.getId())
                .address(shop.getAddress())
                .name(shop.getName())
                .numberOfEmployees(shop.getNumberOfEmployees())
                .hasSite(shop.isHasSite())
                .build();
    }

    public static Shop transformToDao(ShopDto shopDto) {
        return Shop.builder()
                .id(shopDto.getId())
                .address(shopDto.getAddress())
                .name(shopDto.getName())
                .numberOfEmployees(shopDto.getNumberOfEmployees())
                .hasSite(shopDto.isHasSite())
                .build();
    }
}
