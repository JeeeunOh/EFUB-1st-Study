package com.efub.kurlyclone.domain.category;

import com.efub.kurlyclone.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
