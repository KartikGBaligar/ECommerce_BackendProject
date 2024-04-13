package com.kartik.ecomcart.Service;

import com.kartik.ecomcart.Model.Product;
import com.kartik.ecomcart.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public Product createProduct(Long id)
    {
        Product product = new Product();
        product.setId(id);
        return productRepository.save(product);
    }

}
