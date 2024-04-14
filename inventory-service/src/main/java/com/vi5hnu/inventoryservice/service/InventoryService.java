package com.vi5hnu.inventoryservice.service;

import com.vi5hnu.inventoryservice.dto.InventoryDto;
import com.vi5hnu.inventoryservice.exception.InventoryException;
import com.vi5hnu.inventoryservice.model.Inventory;
import com.vi5hnu.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public InventoryDto getStock(String skuCode){
        if(skuCode==null) throw new InventoryException(HttpStatus.BAD_REQUEST,"Invalid Sku-Code");
        final var inventory = inventoryRepository.findBySkuCode(skuCode).orElseThrow(()->new InventoryException(HttpStatus.BAD_REQUEST,"Invalid Sku-Code"));
        return mapToDto(inventory);
    }


    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode,Integer quantity){
        if(skuCode==null) throw new InventoryException(HttpStatus.BAD_REQUEST,"Invalid Sku-Code");
        final var inventory = inventoryRepository.findBySkuCode(skuCode).orElseThrow(()->new InventoryException(HttpStatus.BAD_REQUEST,"Invalid Sku-Code"));
        return inventory.getQuantity()>=quantity;
    }

    @Transactional(readOnly = true)
    public List<InventoryDto> getStocks(List<String> skuCodes){
        if(skuCodes.isEmpty()) throw new InventoryException(HttpStatus.BAD_REQUEST,"Invalid Sku-Codes");
        final var inventorys = inventoryRepository.findBySkuCodeIn(skuCodes);
        if(inventorys.size()!=skuCodes.size()) throw new InventoryException(HttpStatus.BAD_REQUEST,"Invalid Sku-Codes found");
        return inventorys.stream().map(inv->mapToDto(inv.get())).toList();
    }

    private InventoryDto mapToDto(Inventory inventory){
        return new InventoryDto(inventory.getId(),inventory.getSkuCode(),inventory.getQuantity());
    }
}
