package com.kartik.ecommerce_fakestore.Service;

import com.kartik.ecommerce_fakestore.DTO.ProductListResponseDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductRequestDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductResponseDTO;
import org.springframework.stereotype.Service;


public interface ProductService
{
    public ProductResponseDTO getProductByID(Long id);
    public ProductListResponseDTO getAllProducts();
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    public boolean deleteProductByID(Long id);
}
