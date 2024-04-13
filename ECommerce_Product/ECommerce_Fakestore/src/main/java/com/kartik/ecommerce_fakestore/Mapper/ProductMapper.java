package com.kartik.ecommerce_fakestore.Mapper;

import com.kartik.ecommerce_fakestore.DTO.FakeStoreProductRequestDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductListResponseDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductRequestDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductResponseDTO;
import com.kartik.ecommerce_fakestore.Models.Product;

import java.util.List;

public class ProductMapper
{
        public static FakeStoreProductRequestDTO productRequestDTOtoFakeStoreProductRequest(ProductRequestDTO productRequestDTO)
        {
            FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
            fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
            fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
            fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
            fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
            fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
            return fakeStoreProductRequestDTO;
        }

    public static ProductResponseDTO FakeStoreProductResponsetoProductResponseDTOto(FakeStoreProductRequestDTO fakeStoreProductRequestDTO)
    {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setCategory(fakeStoreProductRequestDTO.getCategory());
        productResponseDTO.setDescription(fakeStoreProductRequestDTO.getDescription());
        productResponseDTO.setTitle(fakeStoreProductRequestDTO.getTitle());
        productResponseDTO.setPrice(fakeStoreProductRequestDTO.getPrice());
        productResponseDTO.setImage(fakeStoreProductRequestDTO.getImage());
        return productResponseDTO;
    }

    public static ProductListResponseDTO convertProductsToProductListResponseDTO(List<Product> products){
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(Product p : products){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setID(p.getId());
            productResponseDTO.setImage(p.getImage());
            productResponseDTO.setTitle(p.getTitle());
            productResponseDTO.setPrice(p.getPrice().getAmount());
            productResponseDTO.setDescription(p.getDescription());
            productResponseDTO.setCategory(p.getCategory().getCategoryname());
            productListResponseDTO.getProducts().add(productResponseDTO);
        }
        return productListResponseDTO;
    }

    public static Product convertProductRequestDTOtoProduct(ProductRequestDTO productRequestDTO)
    {
        Product product=new Product();
        product.setId(productRequestDTO.getID());
        product.setTitle(productRequestDTO.getTitle());
        product.setDescription(productRequestDTO.getDescription());
        product.setImage(product.getImage());
        return product;
    }

    public static ProductResponseDTO convertProducttoProductResponseDTO(Product product)
    {
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setID(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImage(product.getImage());

        return productResponseDTO;
    }


}
