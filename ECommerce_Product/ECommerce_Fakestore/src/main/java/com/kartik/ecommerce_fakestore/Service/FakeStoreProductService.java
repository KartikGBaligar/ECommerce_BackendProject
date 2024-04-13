package com.kartik.ecommerce_fakestore.Service;

import com.kartik.ecommerce_fakestore.Client.FakeStoreAPIClient;
import com.kartik.ecommerce_fakestore.DTO.*;
import com.kartik.ecommerce_fakestore.Mapper.ProductMapper;
import com.kartik.ecommerce_fakestore.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService
{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient)
    {
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreAPIClient=fakeStoreAPIClient;
    }

    public ProductResponseDTO getProductByID(Long ID)
    {
        String getProductUrl = "https://fakestoreapi.com/products/"+ID;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(getProductUrl, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    public ProductListResponseDTO getAllProducts()
    {
        String getProductUrl = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getProductUrl, ProductResponseDTO[].class);
        ProductListResponseDTO responseDTO=new ProductListResponseDTO();
        for(ProductResponseDTO productResponse: productResponseArray.getBody())
        {
            responseDTO.getProducts().add(productResponse);
        }
        return responseDTO;

        //ProductResponseDTO[].class: It specifies the type of class in which we want to get the response back

    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO)
    {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = ProductMapper.productRequestDTOtoFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        ProductResponseDTO productResponseDTO=ProductMapper.FakeStoreProductResponsetoProductResponseDTOto(fakeStoreProductRequestDTO);
        return productResponseDTO;
    }

    public boolean deleteProductByID(Long id)
    {
        String deleteProductUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductUrl);
        return true;
    }

}
