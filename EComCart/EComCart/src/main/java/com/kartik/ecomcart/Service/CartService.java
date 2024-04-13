package com.kartik.ecomcart.Service;

import com.kartik.ecomcart.DTO.CartDetailsResponseDTO;
import com.kartik.ecomcart.DTO.CartResponseDTO;
import com.kartik.ecomcart.Mapper.CartMapper;
import com.kartik.ecomcart.Model.Cart;
import com.kartik.ecomcart.Model.Product;
import com.kartik.ecomcart.Model.User;
import com.kartik.ecomcart.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository)
    {
        this.cartRepository=cartRepository;
    }

    public CartResponseDTO addtocart(User user, Product product)
    {
            Optional<Cart> optionalCart = Optional.ofNullable(cartRepository.findByUserId(user.getId()));
            if(optionalCart.isEmpty()) {
                Cart cart = new Cart();
                cart.setUser(user);
                cart.getProducts().add(product);
                cartRepository.save(cart);
                CartResponseDTO cartResponseDTO = CartMapper.carttocartResponseDTO(cart);
                return cartResponseDTO;
            }
            else
            {
                Cart cart = optionalCart.get();
                cart.setUser(user);
                cart.getProducts().add(product);
                cartRepository.save(cart);
                CartResponseDTO cartResponseDTO = CartMapper.carttocartResponseDTO(cart);
                return cartResponseDTO;
            }
    }

    public CartDetailsResponseDTO viewcart(Long id)
    {
        Optional<Cart> optionalCart = Optional.ofNullable(cartRepository.findByUserId(id));
        Cart cart = optionalCart.get();
        CartDetailsResponseDTO cartDetailsResponseDTO = CartMapper.cartToCartDetailsResponseDTO(cart);
        return cartDetailsResponseDTO;

    }

    public boolean deletefromcart(Long productid)
    {
        cartRepository.deleteFromCartProductsByProductId(productid);
        return true;
    }
}
