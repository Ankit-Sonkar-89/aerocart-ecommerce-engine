// package com.investtech.ecommerce_engine.controller;

// public class AdminController {
    
// }

// (Ye aapki SQL queries ko Java ke through execute karega aur Naye products Database mein add karega)

package com.investtech.ecommerce_engine.controller;

import com.investtech.ecommerce_engine.model.ProductDetail;
import com.investtech.ecommerce_engine.repository.ProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    private final ProductRepository productRepository;
    private final JdbcTemplate jdbcTemplate;

    public AdminController(ProductRepository productRepository, JdbcTemplate jdbcTemplate) {
        this.productRepository = productRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🟢 1. ADD NEW PRODUCT (Admin can add new stocks/gadgets)
    @PostMapping("/add-product")
    public ProductDetail addProduct(@RequestBody ProductDetail product) {
        return productRepository.save(product); // Hibernate automatically saves it to MySQL!
    }

    // 🟢 2. ANALYTICS: TOTAL REVENUE (Using your exact SQL query)
    @GetMapping("/revenue")
    public Map<String, Object> getTotalRevenue() {
        String sql = "SELECT SUM(QUANTITY * PRICE) AS TOTAL_REVENUE FROM ORDER_ITEMS_DETAIL";
        return jdbcTemplate.queryForMap(sql);
    }

    // 🟢 3. ANALYTICS: TOP 5 PRODUCTS
    @GetMapping("/top-products")
    public List<Map<String, Object>> getTopProducts() {
        String sql = "SELECT P.NAME, SUM(OI.QUANTITY) AS TOTAL_SOLD " +
                     "FROM ORDER_ITEMS_DETAIL OI " +
                     "JOIN PRODUCTS_DETAIL P ON OI.PRODUCT_ID = P.PRODUCT_ID " +
                     "GROUP BY P.NAME ORDER BY TOTAL_SOLD DESC LIMIT 5";
        return jdbcTemplate.queryForList(sql);
    }

    // 🟢 4. ANALYTICS: CATEGORY WISE SALES
    @GetMapping("/category-sales")
    public List<Map<String, Object>> getCategorySales() {
        String sql = "SELECT P.CATEGORY, SUM(OI.QUANTITY * OI.PRICE) AS CATEGORY_SALES " +
                     "FROM PRODUCTS_DETAIL P " +
                     "JOIN ORDER_ITEMS_DETAIL OI ON P.PRODUCT_ID = OI.PRODUCT_ID " +
                     "GROUP BY P.CATEGORY";
        return jdbcTemplate.queryForList(sql);
    }
}