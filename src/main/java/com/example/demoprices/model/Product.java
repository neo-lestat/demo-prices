package com.example.demoprices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "product",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"name"})})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
