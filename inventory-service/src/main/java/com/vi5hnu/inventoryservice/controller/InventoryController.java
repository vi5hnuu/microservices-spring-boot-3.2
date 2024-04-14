package com.vi5hnu.inventoryservice.controller;

import com.vi5hnu.inventoryservice.dto.InventoryDto;
import com.vi5hnu.inventoryservice.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("sku-code/{sku-code}/stock")
    public ResponseEntity<Map<String, Object>> getStock(@PathVariable(name = "sku-code") String skuCode){
        final InventoryDto dto=inventoryService.getStock(skuCode);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.ofEntries(Map.entry("success",true),Map.entry("data",dto)));
    }
    @GetMapping("stock")
    public ResponseEntity<Map<String, Object>> getStock(@RequestParam(name = "sku-code") List<String> skuCode){
        final var dtos=inventoryService.getStocks(skuCode);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.ofEntries(Map.entry("success",true),Map.entry("data",dtos)));
    }
}
