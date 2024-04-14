package com.vi5hnu.productservice.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.TimeSeries;

import java.math.BigDecimal;

@Document(collection = Product.COLLECTION_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    public static final String COLLECTION_NAME="product";

    @Id
    @Field(name="id",write = Field.Write.ALWAYS,targetType = FieldType.OBJECT_ID) private String id;
    @Field(name="name",write = Field.Write.ALWAYS,targetType = FieldType.STRING) private String name;
    @Field(name="description",write = Field.Write.ALWAYS,targetType = FieldType.STRING) private String description;
    @Field(name="price",write = Field.Write.ALWAYS,targetType = FieldType.DECIMAL128) private BigDecimal price;
}
