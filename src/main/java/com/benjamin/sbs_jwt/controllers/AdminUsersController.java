package com.benjamin.sbs_jwt.controllers;

import com.benjamin.sbs_jwt.dtos.RequestResponse;
import com.benjamin.sbs_jwt.entities.Product;
import com.benjamin.sbs_jwt.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminUsersController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/public/product")
    public ResponseEntity<Object> getAllProduct(){
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping("/admin/saveproduct")
    public ResponseEntity<Object> signUp(@RequestBody RequestResponse productRequest){
        Product productToSave = new Product();
        productToSave.setName(productRequest.getName());
        return ResponseEntity.ok(productRepo.save(productToSave));
    }

    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone(){
        return ResponseEntity.ok("USERS alone can access this endpoint");
    }
    @GetMapping("/admin/user")
    public ResponseEntity<Object> adminAndUserApi(){
        return ResponseEntity.ok("ADMIN and USER can access this API");
    }
}
