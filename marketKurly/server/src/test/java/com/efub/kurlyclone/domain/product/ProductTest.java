package com.efub.kurlyclone.domain.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductTest {
    @Autowired
    ProductRepository productRepository;

    @AfterEach
    public void cleanup(){
        productRepository.deleteAll();
    }

    @Test
    public void 불러오기(){
        String name = "고등어";
        Integer price = 30000;
        Long category = 1L;
        String image = "uploads/..";

        productRepository.save(Product.builder().product_name(name)
                .product_price(price).product_image(image).category(category)
                .build());

        List<Product> productList = productRepository.findAll();

        Product product = productList.get(0);
        then(product.getProduct_name()).isEqualTo(name);
        then(product.getProduct_price()).isEqualTo(price);
    }
}