// package com.investtech.ecommerce_engine.controller;

// public class StoreController {
    
// }

// (Ye humari APIs hain jo Frontend Store UI se connect hongi)

package com.investtech.ecommerce_engine.controller;

import com.investtech.ecommerce_engine.model.OrderRequest;
import com.investtech.ecommerce_engine.model.ProductDetail;
import com.investtech.ecommerce_engine.repository.ProductRepository;
import com.investtech.ecommerce_engine.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/store")
@CrossOrigin("*") // Frontend connectivity allow karne ke liye
public class StoreController {

    private final ProductRepository productRepository;
    private final OrderService orderService;

    public StoreController(ProductRepository productRepository, OrderService orderService) {
        this.productRepository = productRepository;
        this.orderService = orderService;
    }

    // API 1: Get all products to display on the storefront
    @GetMapping("/products")
    public List<ProductDetail> getAllProducts() {
        return productRepository.findAll();
    }

    // API 2: Place an order using Stored Procedure
    @PostMapping("/checkout")
    public Map<String, String> checkout(@RequestBody OrderRequest request) {
        String responseMessage = orderService.placeOrderViaProcedure(
                request.getCustomerId(), 
                request.getProductId(), 
                request.getQuantity()
        );
        return Map.of("message", responseMessage);
    }
}