package com.kartik.ecommerce_fakestore.Service;

import com.kartik.ecommerce_fakestore.DTO.ProductListResponseDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductRequestDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductResponseDTO;
import com.kartik.ecommerce_fakestore.Mapper.ProductMapper;
import com.kartik.ecommerce_fakestore.Models.Category;
import com.kartik.ecommerce_fakestore.Models.Product;
import com.kartik.ecommerce_fakestore.Repository.CategoryRepository;
import com.kartik.ecommerce_fakestore.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("ProductService")
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    public ProductListResponseDTO getAllProducts()
    {
        List<Product> products = productRepository.findAll();
        ProductListResponseDTO productListResponseDTO = ProductMapper.convertProductsToProductListResponseDTO(products);
        return productListResponseDTO;
    }

    public ProductResponseDTO getProductByID(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.get();
        ProductResponseDTO productResponseDTO =ProductMapper.convertProducttoProductResponseDTO(product);
        return productResponseDTO;
    }


    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product=ProductMapper.convertProductRequestDTOtoProduct(productRequestDTO);
        product=productRepository.save(product);
        ProductResponseDTO productResponseDTO=ProductMapper.convertProducttoProductResponseDTO(product);
        return productResponseDTO;
    }


    public boolean deleteProductByID(Long id) {
        productRepository.deleteById(id);
        return true;
    }

}
