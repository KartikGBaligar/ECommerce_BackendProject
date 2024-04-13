package com.example.ecomorder.Service;

import com.example.ecomorder.Model.Product;
import com.example.ecomorder.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> createProduct(List<Long> productids)
    {
        List<Product> products = new ArrayList<>();
        for(int i=0; i<productids.size(); i++) {
            Product product = new Product();
            product.setId(productids.get(i));
            productRepository.save(product);
        }
        return products;
    }
}
