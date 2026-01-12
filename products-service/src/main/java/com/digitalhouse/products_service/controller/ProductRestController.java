package com.digitalhouse.products_service.controller;

import com.digitalhouse.products_service.entity.Product;
import jakarta.ws.rs.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @GetMapping
    public Product getProduct(
            @RequestParam String id,
            @RequestParam(required = false, defaultValue = "false") Boolean throwError
    ) {

        if (throwError) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Simulated error"
            );
        }

        return new Product(id, "Product " + id, 100.0);
    }

}
