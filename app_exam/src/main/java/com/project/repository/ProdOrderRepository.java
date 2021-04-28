package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.ProductOrder;

public interface ProdOrderRepository extends JpaRepository<ProductOrder, Long> {
}
