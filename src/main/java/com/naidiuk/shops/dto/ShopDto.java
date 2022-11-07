package com.naidiuk.shops.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShopDto {
    private Long id;
    private String address;
    private String name;
    private int numberOfEmployees;
    private boolean hasSite;
}
