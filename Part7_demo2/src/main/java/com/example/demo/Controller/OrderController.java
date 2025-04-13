package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return Optional.ofNullable(orderService.getOrderById(id));
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateById(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    // API lấy danh sách đơn hàng theo customerId
    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    // API lấy thông tin khách hàng từ orderId
    @GetMapping("/{orderId}/customer")
    public Customer getCustomerByOrderId(@PathVariable Long orderId) {
        return orderService.getCustomerByOrderId(orderId);
    }

}
