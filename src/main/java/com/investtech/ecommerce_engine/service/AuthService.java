// package com.investtech.ecommerce_engine.service;

// public @interface AuthService {
    
// }

// (Ye OTP generate karega aur asali email bhejega)

package com.investtech.ecommerce_engine.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {

    private final JavaMailSender mailSender;
    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();

    public AuthService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String generateAndSendOtp(String email) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        otpStorage.put(email, otp);

        try {
            // 🔥 ADVANCED MAIL SENDER (To show Custom Name "AeroCart")
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            // Yahan "AeroCart" set kiya gaya hai as sender name!
            helper.setFrom("sonkarankit624@gmail.com", "AeroCart Security"); 
            helper.setTo(email);
            helper.setSubject("Your AeroCart Secure Login OTP 🚀");
            
            String htmlBody = "<h3>Welcome to AeroCart!</h3>"
                            + "<p>Your One-Time Password (OTP) for login is: <b style='font-size:20px; color:#38bdf8;'>" + otp + "</b></p>"
                            + "<p><i>Please do not share this code with anyone.</i></p>";
            helper.setText(htmlBody, true); // true indicates HTML format

            mailSender.send(message);
            return "OTP sent successfully to " + email;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send OTP. Check console.";
        }
    }

    public boolean verifyOtp(String email, String enteredOtp) {
        if (otpStorage.containsKey(email) && otpStorage.get(email).equals(enteredOtp)) {
            otpStorage.remove(email);
            return true;
        }
        return false;
    }
}

