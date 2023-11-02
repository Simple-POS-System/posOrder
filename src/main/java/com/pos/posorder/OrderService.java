package com.pos.posorder;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public String generateProductId(){
        Order lastOrder = orderRepository.findFirstByOrderByOrderIdDesc();
        if(lastOrder != null){
            int lastOrderId = Integer.parseInt(lastOrder.getOrderId().substring(1));
            int newOrderId = lastOrderId + 1;
            return "O" + newOrderId;
        }else {
            return "O1";
        }
    }

    public LocalDateTime getCurrentTime(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toLocalDateTime();
    }

    public ResponseEntity<Order> saveOrder(Order order){
        order.setOrderId(generateProductId());
        order.setOrderTime(getCurrentTime());
        order.setOrderStatus(OrderStatus.PACKING);
        return ResponseEntity.ok(orderRepository.save(order));
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public ResponseEntity<?> getOrderByOrderId(String orderId){
        return ResponseEntity.ok(orderRepository.getOrderByOrderId(orderId));
    }
}
