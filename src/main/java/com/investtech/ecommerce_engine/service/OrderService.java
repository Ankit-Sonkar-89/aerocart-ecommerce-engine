// package com.investtech.ecommerce_engine.service;

// public class OrderService {
    
// }

// (Ye class Spring Boot ke JdbcTemplate ka use karke seedha aapke MySQL ke andar ghusegi aur aapka likha hua PLACE_ORDER procedure fire karegi!)

package com.investtech.ecommerce_engine.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final JdbcTemplate jdbcTemplate;

    public OrderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String placeOrderViaProcedure(int customerId, int productId, int quantity) {
        // 🔥 Calling your custom MySQL Stored Procedure!
        String sql = "CALL PLACE_ORDER(?, ?, ?)";
        
        try {
            // Executing the procedure and capturing the "SELECT ... AS MESSAGE" result
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, customerId, productId, quantity);
            
            if (!result.isEmpty() && result.get(0).containsKey("MESSAGE")) {
                return result.get(0).get("MESSAGE").toString();
            }
            return "Order Processed";
        } catch (Exception e) {
            e.printStackTrace();
            return "Transaction Failed: " + e.getMessage();
        }
    }
}