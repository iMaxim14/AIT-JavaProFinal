package de.ait.javalessons.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductControllerHW13 {

    @GetMapping("/public/list")
    public ResponseEntity<String> getPublicInfo() {
        return ResponseEntity.ok("User info, public information");
    }

    @GetMapping("/customer/cart")
    public ResponseEntity<String> getCustomerInfo(){
        return ResponseEntity.ok("User info, secured customer information");
    }

    @GetMapping("/manager/add")
    public ResponseEntity<String> getManagerInfo(){
        return ResponseEntity.ok("User info, secured manager information");
    }
}
