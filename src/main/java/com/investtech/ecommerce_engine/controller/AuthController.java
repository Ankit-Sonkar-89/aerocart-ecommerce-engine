// package com.investtech.ecommerce_engine.controller;

// public class AuthController {
    
// }

// (Ye APIs frontend ko connect karengi)

package com.investtech.ecommerce_engine.controller;

import com.investtech.ecommerce_engine.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/send-otp")
    public Map<String, String> sendOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String msg = authService.generateAndSendOtp(email);
        return Map.of("message", msg);
    }

    @PostMapping("/verify-otp")
    public Map<String, Object> verifyOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");
        boolean isValid = authService.verifyOtp(email, otp);
        
        if (isValid) {
            return Map.of("success", true, "message", "Login Successful!");
        } else {
            return Map.of("success", false, "message", "Invalid or Expired OTP!");
        }
    }
}