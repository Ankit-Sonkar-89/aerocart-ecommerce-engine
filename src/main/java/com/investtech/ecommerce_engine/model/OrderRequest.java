// package com.investtech.ecommerce_engine.model;

// public class OrderRequest {
    
// }

// (Ye DTO (Data Transfer Object) hai. Frontend se jo user Buy karega, uska data isme aayega)

package com.investtech.ecommerce_engine.model;

import lombok.Data;

@Data
public class OrderRequest {
    private int customerId;
    private int productId;
    private int quantity;
}