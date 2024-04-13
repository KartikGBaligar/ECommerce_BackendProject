package com.example.ecomorder.Controller;

import com.example.ecomorder.DTO.OrderRequestDTO;
import com.example.ecomorder.DTO.OrderResponseDTO;
import com.example.ecomorder.DTO.ViewOrderRequestDTO;
import com.example.ecomorder.Model.EComOrder;
import com.example.ecomorder.Model.Product;
import com.example.ecomorder.Model.User;
import com.example.ecomorder.Service.OrderService;
import com.example.ecomorder.Service.ProductService;
import com.example.ecomorder.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class OrderController {
    private OrderService orderService;
    private ProductService productService;
    private UserService userService;

    public OrderController(OrderService orderService, ProductService productService, UserService userService)
    {
        this.orderService=orderService;
        this.productService=productService;
        this.userService=userService;
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponseDTO> placeorder(@RequestBody OrderRequestDTO orderRequestDTO)
    {
        User user = userService.findUser(orderRequestDTO.getUserid());
        List<Long> productids = new ArrayList<>();
        for(int i=0;i<orderRequestDTO.getProductids().length;i++)
            productids.add(orderRequestDTO.getProductids()[i]);
        List<Product> products = productService.createProduct(productids);
        OrderResponseDTO orderResponseDTO = orderService.placeorder(user,products);
        return ResponseEntity.ok(orderResponseDTO);
    }

    @GetMapping("/order")
    public ResponseEntity<List<EComOrder>> vieworder(@RequestBody ViewOrderRequestDTO viewOrderRequestDTO){
        List<EComOrder> eComOrderList = orderService.vieworder(viewOrderRequestDTO.getUserid());
        return ResponseEntity.ok(eComOrderList);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteorder(@PathVariable("id") Long id)
    {
        boolean response = orderService.deleteorder(id);
        return ResponseEntity.ok(response);
    }
}
