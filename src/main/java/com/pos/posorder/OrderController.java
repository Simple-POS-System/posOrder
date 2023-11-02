package com.pos.posorder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/getById/{orderId}")
    public ResponseEntity<?> getOrderByOrderId(@PathVariable String orderId){
        return orderService.getOrderByOrderId(orderId);
    }


}
