package com.example.ecomorder.Service;

import com.example.ecomorder.DTO.OrderResponseDTO;
import com.example.ecomorder.Mapper.OrderMapper;
import com.example.ecomorder.Model.EComOrder;
import com.example.ecomorder.Model.Product;
import com.example.ecomorder.Model.User;
import com.example.ecomorder.Repository.EComOrderRepository;
import com.example.ecomorder.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private EComOrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(EComOrderRepository orderRepository)
    {
        this.orderRepository=orderRepository;
        this.productRepository=productRepository;

    }

    public OrderResponseDTO placeorder(User user, List<Product> products)
    {
        EComOrder eComOrder = new EComOrder();
        eComOrder.setUser(user);
        eComOrder.setProducts(products);
        orderRepository.save(eComOrder);
        for(int i=0;i<eComOrder.getProducts().size();i++) {
            orderRepository.insert(eComOrder.getId(), eComOrder.getProducts().get(i).getId());
        }
        OrderResponseDTO orderResponseDTO = OrderMapper.ordertoorderResponseDTO(eComOrder);
        return orderResponseDTO;
    }

    public List<EComOrder> vieworder(Long userid)
    {
        List<EComOrder> eComOrderList = orderRepository.findByUserId(userid);

        return eComOrderList;
    }
    public boolean deleteorder(Long id)
    {
        orderRepository.deleteById(id);
        return true;
    }
}
