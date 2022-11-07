package com.naidiuk.shops.entity;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop {
    private Long id;
    private String address;
    private String name;
    private int numberOfEmployees;
    private boolean hasSite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return numberOfEmployees == shop.numberOfEmployees
                && hasSite == shop.hasSite
                && Objects.equals(address, shop.address)
                && Objects.equals(name, shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name, numberOfEmployees, hasSite);
    }
}
