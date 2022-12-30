package com.efub.kurlyclone.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    List<Product> findProductsBySaleGreaterThan(float num);
    List<Product> findProductsByCategoryAndRecommendEquals(Long cat, int num);

}
