package com.example.demoprices.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "price",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"name"})})
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name="start_date")
    private LocalDateTime startDate;
    @Column (name="end_date")
    private LocalDateTime endDate;
    private Integer priority;
    private Double price; //BigDecimal ?
    private String currency;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false, updatable = false)
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(id, price.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
