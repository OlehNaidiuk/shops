package com.naidiuk.shops.service;

import com.naidiuk.shops.dto.ShopDto;
import com.naidiuk.shops.entity.Shop;
import com.naidiuk.shops.error.ShopNotFoundException;
import com.naidiuk.shops.mapper.ShopMapper;
import com.naidiuk.shops.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public ShopDto save(ShopDto shopDto) {
        Shop shopForSave = ShopMapper.transformToDao(shopDto);
        Shop savedShop = shopRepository.save(shopForSave);
        return ShopMapper.transformToDto(savedShop);
    }

    @Override
    public ShopDto findById(Long id) {
        Shop shop = shopRepository.findById(id);
        if (shop == null) {
            throw new ShopNotFoundException(
                    String.format("Shop with id=%d not found", id));
        }
        return ShopMapper.transformToDto(shop);
    }

    @Override
    public ShopDto deleteById(Long id) {
        Shop deletedShop = shopRepository.deleteById(id);
        if (deletedShop == null) {
            throw new ShopNotFoundException(
                    String.format("Shop with id=%d not found", id));
        }
        return ShopMapper.transformToDto(deletedShop);
    }

    @Override
    public ShopDto update(ShopDto shopDtoForUpdate) {
        Shop shopForUpdate = ShopMapper.transformToDao(shopDtoForUpdate);
        Shop updatedShop = shopRepository.update(shopForUpdate);
        return ShopMapper.transformToDto(updatedShop);
    }

    @Override
    public List<ShopDto> getAll() {
        List<Shop> shops = shopRepository.getAll();
        return shops.stream()
                .map(ShopMapper::transformToDto)
                .collect(Collectors.toList());
    }
}
