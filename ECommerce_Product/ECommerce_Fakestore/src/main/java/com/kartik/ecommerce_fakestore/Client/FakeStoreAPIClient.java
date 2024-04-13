package com.kartik.ecommerce_fakestore.Client;

import com.kartik.ecommerce_fakestore.DTO.FakeStoreProductRequestDTO;
import com.kartik.ecommerce_fakestore.DTO.FakeStoreProductResponseDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductRequestDTO;
import com.kartik.ecommerce_fakestore.DTO.ProductResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreAPIClient {

    RestTemplateBuilder restTemplateBuilder;
    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO)
    {
        String createProductUrl = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(createProductUrl,fakeStoreProductRequestDTO,FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }
}
