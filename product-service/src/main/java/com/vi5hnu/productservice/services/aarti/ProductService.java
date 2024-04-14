package com.vi5hnu.productservice.services.aarti;

import com.vi5hnu.productservice.dto.ProductRequest;
import com.vi5hnu.productservice.dto.ProductResponse;
import com.vi5hnu.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    Optional<ProductResponse> getProductById(String productId);
    List<ProductResponse> getAllProduct();
    ProductResponse mapToProductResponse(Product product);
}
