package com.kartik.ecomcart.Controller;

import com.kartik.ecomcart.DTO.CartDetailsResponseDTO;
import com.kartik.ecomcart.DTO.CartRequestDTO;
import com.kartik.ecomcart.DTO.CartResponseDTO;
import com.kartik.ecomcart.Model.Product;
import com.kartik.ecomcart.Model.User;
import com.kartik.ecomcart.Service.CartService;
import com.kartik.ecomcart.Service.ProductService;
import com.kartik.ecomcart.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private CartService cartService;
    private UserService userService;
    private ProductService productService;

    public CartController(CartService cartService, UserService userService, ProductService productService)
    {
        this.cartService=cartService;
        this.userService=userService;
        this.productService=productService;
    }

    @PostMapping("/cart")
    public ResponseEntity<CartResponseDTO> addtocart(@RequestBody CartRequestDTO cartRequestDTO)
    {
        User user = userService.findUser(cartRequestDTO.getUserid());
        Product product = productService.createProduct(cartRequestDTO.getProductid());
        CartResponseDTO cartResponseDTO = cartService.addtocart(user, product);
        return ResponseEntity.ok(cartResponseDTO);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<CartDetailsResponseDTO> viewcart(@PathVariable("id") Long id)
    {
        CartDetailsResponseDTO cartDetailsResponseDTO = cartService.viewcart(id);

        return ResponseEntity.ok(cartDetailsResponseDTO);
    }

    @DeleteMapping("/cart")
    public ResponseEntity deletefromcart(@RequestBody CartRequestDTO cartRequestDTO)
    {
        boolean response = cartService.deletefromcart(cartRequestDTO.getProductid());
        return ResponseEntity.ok(response);
    }

}
