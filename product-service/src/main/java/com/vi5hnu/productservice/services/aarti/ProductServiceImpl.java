package com.vi5hnu.productservice.services.aarti;

import com.vi5hnu.productservice.dto.ProductRequest;
import com.vi5hnu.productservice.dto.ProductResponse;
import com.vi5hnu.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final MongoTemplate mongoTemplate;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        final Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        final var savedProduct = mongoTemplate.save(product,Product.COLLECTION_NAME);
        log.info("Product {}[{}] is saved.",savedProduct.getName(),savedProduct.getId());
        return mapToProductResponse(product);
    }

    @Override
    public Optional<ProductResponse> getProductById(String productId) {
        return  Optional.of(mapToProductResponse(mongoTemplate.findOne(Query.query(Criteria.where("id").is(new ObjectId(productId))),Product.class,Product.COLLECTION_NAME)));
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return mongoTemplate.findAll(Product.class).stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public ProductResponse mapToProductResponse(Product product) {
        return product!=null ? ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build() : null;
    }

}
