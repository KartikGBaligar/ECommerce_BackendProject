package com.kartik.ecommerce_fakestore.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartik.ecommerce_fakestore.Client.UserServiceClient;
import com.kartik.ecommerce_fakestore.DTO.*;
import com.kartik.ecommerce_fakestore.InvalidTokenException;
import com.kartik.ecommerce_fakestore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@RestController
public class ProductController
{


  private ProductService productservice;
  private UserServiceClient userServiceClient;

  @Autowired
  public ProductController( @Qualifier("ProductService")ProductService productservice, UserServiceClient userServiceClient)
  {
    this.productservice = productservice;
    this.userServiceClient = userServiceClient;
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<ProductResponseDTO> getProductFromID(@PathVariable("id") Long id,@RequestHeader("token") String token) throws Exception {
        validateUser(token);
        ProductResponseDTO response = productservice.getProductByID(id);
        return ResponseEntity.ok(response);
      }

  @GetMapping("/products")
  public ResponseEntity<ProductListResponseDTO> getProductsAll(@RequestHeader("token") String token) throws Exception {
    validateUser(token);
    ProductListResponseDTO response = productservice.getAllProducts();
    return ResponseEntity.ok(response);
  }

  @PostMapping("/products")
  public ResponseEntity<ProductResponseDTO> insertProduct(@RequestHeader("token") String token,ProductRequestDTO productRequestDTO) throws Exception {
    validateUser(token);
    ProductResponseDTO response = productservice.createProduct(productRequestDTO);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity deleteProductFromID(@PathVariable("id") Long id,@RequestHeader("token") String token) throws Exception {
    validateUser(token);
    boolean response = productservice.deleteProductByID(id);
    return ResponseEntity.ok(response);
  }

  private void validateUser(String token) throws Exception
  {
    String[] chunks = token.split("\\.");
    Base64.Decoder decoder = Base64.getUrlDecoder();
    String payload = new String(decoder.decode(chunks[1]));
    ObjectMapper mapper = new ObjectMapper();
    JWTPayloadDTO jwtPayload = mapper.readValue(payload, JWTPayloadDTO.class);
    Long userID = jwtPayload.getUserID();
    ValidateTokenDTO validateTokenDTO = new ValidateTokenDTO(userID, token);
    String result = userServiceClient.validateToken(validateTokenDTO);
    if(!result.contains(SessionStatus.ACTIVE.name())){
      throw new InvalidTokenException("Token is not valid");
    }
  }
}
