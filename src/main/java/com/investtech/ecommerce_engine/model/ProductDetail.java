// package com.investtech.ecommerce_engine.model;

// public class ProductDetail {
    
// }

package com.investtech.ecommerce_engine.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTS_DETAIL")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STOCK_QUANTITY")
    private Integer stockQuantity;
}