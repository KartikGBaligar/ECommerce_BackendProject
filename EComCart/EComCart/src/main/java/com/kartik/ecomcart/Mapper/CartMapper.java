package com.kartik.ecomcart.Mapper;

import com.kartik.ecomcart.DTO.CartDetailsResponseDTO;
import com.kartik.ecomcart.DTO.CartResponseDTO;
import com.kartik.ecomcart.Model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartMapper {
    public static CartResponseDTO carttocartResponseDTO(Cart cart)
    {
        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setUserid((cart.getUser().getId()));
        cartResponseDTO.setProductid(cart.getProducts().get(cart.getProducts().size()-1).getId());
        cartResponseDTO.setCartid(cart.getId());

        return cartResponseDTO;
    }

//    public static List<CartResponseDTO> cartlisttocartResponseDTOlist(List<Cart> cartlist)
//    {
//        List<CartResponseDTO> cartResponseDTOList = new ArrayList<>();
//        int N= cartlist.size();
//        for(int i=0;i<N;i++)
//        {
//            CartResponseDTO cartResponseDTO = new CartResponseDTO();
//            cartResponseDTO.setUser((cartlist.get(i).getUser()));
//            cartResponseDTO.setProduct(cartlist.get(i).getProducts());
//            cartResponseDTO.setCartid(cartlist.get(i).getId());
//
//            cartResponseDTOList.add(cartResponseDTO);
//        }
//        return cartResponseDTOList;
//    }

    public static CartDetailsResponseDTO cartToCartDetailsResponseDTO(Cart cart)
    {
        CartDetailsResponseDTO cartDetailsResponseDTO = new CartDetailsResponseDTO();
        cartDetailsResponseDTO.setCartid(cart.getId());
        cartDetailsResponseDTO.setUserid(cart.getUser().getId());
        List<Long> productIds = new ArrayList<>();
        for(int i=0;i<cart.getProducts().size();i++)
        {
            productIds.add(cart.getProducts().get(i).getId());
        }

        cartDetailsResponseDTO.setProductIds(productIds);
        return cartDetailsResponseDTO;
    }
}
