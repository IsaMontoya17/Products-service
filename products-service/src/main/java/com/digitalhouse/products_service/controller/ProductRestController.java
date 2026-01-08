package com.digitalhouse.products_service.controller;

import com.digitalhouse.products_service.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @GetMapping
    public ResponseEntity<?> getProduct(
            @RequestParam String id,
            @RequestHeader(value = "X-Request-from", required = false) String requestFrom
    ) {

        if (requestFrom == null || !requestFrom.equals("gateway")) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Access denied: only gateway is allowed");
        }

        Product product = new Product(id, "Notebook", 2000.0);
        return ResponseEntity.ok(product);
    }
}
