package com.efub.kurlyclone.service;

import com.efub.kurlyclone.domain.category.Category;
import com.efub.kurlyclone.domain.category.CategoryRepository;
import com.efub.kurlyclone.domain.product.Product;
import com.efub.kurlyclone.domain.product.ProductRepository;
import com.efub.kurlyclone.web.dto.ProductResponseDto;
import com.efub.kurlyclone.web.dto.ProductSaveRequestDto;
import com.efub.kurlyclone.web.dto.ProductUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final FileHandler fileHandler;

    @Transactional
    public ProductResponseDto findById(Long id){
        Product entity = productRepository.getById(id);
        return new ProductResponseDto(entity);
    }

    @Transactional
    public Long saveProduct(ProductSaveRequestDto productSaveRequestDto, MultipartFile file){
        String file_path;
        Long id;

        try{
            file_path = fileHandler.parseFileInfo(file);
            productSaveRequestDto.setImage(file_path);
        }catch (Exception e){
            System.out.println("File exception");
        }finally {
            id = productRepository.save(productSaveRequestDto.toEntity()).getProduct_id();
        }

        return id;
    }

    @Transactional
    public Long updateProduct(Long id, ProductUpdateDto productUpdateDto){
        Product product = productRepository.getById(id);
        product.update(productUpdateDto.getSale(),
                productUpdateDto.getEvent(),
                productUpdateDto.getRecommend());
        return id;
    }

    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Transactional
    public List<Product> findAll(){
        List<Product> all = productRepository.findAll();
        return all;
    }

    @Transactional
    public List<Product> getRecommend() {
        List<Product> all = productRepository.findAll();
        Collections.shuffle(all);
        List<Product> recommanded = all.subList(0, 4);

        return recommanded;
    }

    @Transactional
    public List<Product> getSale() {
        List<Product> allSale = productRepository.findProductsBySaleGreaterThan((float)0.2);
        Collections.shuffle(allSale);
        List<Product> saleProducts = allSale.subList(0, 4);
        return saleProducts;
    }

    @Transactional
    public List<Product> getMdChoice(String category) {
        Category cat = categoryRepository.findCategoryByName(category);
        Long catnum = cat.getId();
        List<Product> allMd = productRepository.findProductsByCategoryAndRecommendEquals( catnum,1);

        Collections.shuffle(allMd);
        List<Product> mdProducts = allMd.subList(0, 4);
        return mdProducts;
    }

}
