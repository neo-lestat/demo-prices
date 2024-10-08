package com.example.demoprices.repository;

import com.example.demoprices.model.Brand;
import com.example.demoprices.model.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Page<Price> findByNameContaining(String name, Pageable pageable);
}
