package com.example.ecomorder.Mapper;

import com.example.ecomorder.DTO.OrderResponseDTO;
import com.example.ecomorder.Model.EComOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static OrderResponseDTO ordertoorderResponseDTO(EComOrder eComOrder)
    {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderid(eComOrder.getId());
        orderResponseDTO.setUserid(eComOrder.getUser().getId());
        List<Long> productids = new ArrayList<>();
        for(int i=0;i<eComOrder.getProducts().size();i++)
            productids.add(eComOrder.getProducts().get(i).getId());
        orderResponseDTO.setProductids(productids);
        return orderResponseDTO;
    }

    /*public static List<ProductID> longtoProductID(List<Long> productid)
    {
        List<ProductID> productIDS = new ArrayList<>();
        int N = productid.size();
        for(int i=0;i<N;i++)
        {
            ProductID p = new ProductID();
            p.setProductid(productid.get(i));
            productIDS.add(p);
        }
        return productIDS;
    }*/
}
