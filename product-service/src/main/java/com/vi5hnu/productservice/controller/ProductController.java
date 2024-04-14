package com.vi5hnu.productservice.controller;

import com.vi5hnu.productservice.dto.ProductRequest;
import com.vi5hnu.productservice.services.aarti.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController()
@RequestMapping(path = "/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;

    @PostMapping(path = "new",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> createProduct(@RequestBody(required = true) @Valid() ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.ofEntries(Map.entry("success",true),Map.entry("data",productService.createProduct(productRequest))));
    }

    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getProduct(@PathVariable(value = "id",required = true) String productId){
        return ResponseEntity.ok(Map.ofEntries(Map.entry("success",true),Map.entry("data",productService.getProductById(productId))));
    }

    @GetMapping(path = "all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllProduct(){
        return ResponseEntity.ok(Map.ofEntries(Map.entry("success",true),Map.entry("data",productService.getAllProduct())));
    }
}
