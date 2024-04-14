package com.benjamin.sbs_jwt.repositories;

import com.benjamin.sbs_jwt.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
