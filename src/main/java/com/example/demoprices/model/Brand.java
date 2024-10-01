package com.example.demoprices.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "brand",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"name"})})
public class Brand {

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

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
