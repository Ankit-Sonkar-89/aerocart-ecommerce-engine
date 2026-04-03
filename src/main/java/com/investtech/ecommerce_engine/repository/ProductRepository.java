// package com.investtech.ecommerce_engine.repository;

// public class ProductRepository {
    
// }

// (Ye database se products nikalne ke kaam aayega)

package com.investtech.ecommerce_engine.repository;

import com.investtech.ecommerce_engine.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetail, Long> {
}