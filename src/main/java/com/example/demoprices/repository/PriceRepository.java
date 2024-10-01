package com.example.demoprices.repository;

import com.example.demoprices.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p " +
            "WHERE p.startDate <= :applicationDate " +
            "and p.endDate >= :applicationDate " +
            "and p.product.id = :productId " +
            "and p.brand.id = :brandId " +
            "order by p.priority desc limit 1")
    Optional<Price> findPrices(@Param("productId") Long productId,
                               @Param("brandId") Long brandId,
                               @Param("applicationDate")LocalDateTime applicationDate);

}
