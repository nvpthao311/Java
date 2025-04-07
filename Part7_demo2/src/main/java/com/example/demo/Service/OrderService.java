package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    //them
    public Order createOder (Order order) {
        return orderRepository.save(order);
    }

    //sua
    public Order updateById (long id, Order order){
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()){
            Order ord = optionalOrder.get();

            ord.setOrder_date(order.getOrder_date());
            ord.setTotal_price(order.getTotal_price());
            ord.setCustomer(order.getCustomer());

            orderRepository.save(ord);
            return ord;
        }
        return null;
    }

    //xoa
    public void deleteOrder(long id){
        orderRepository.deleteById(id);
    }

    //tim kiem
    public Order getOrderById(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            return  order;
        }
        return null;
    }

    public List<Order> getAllOrder (){
        return orderRepository.findAll();
    }

    // Lấy danh sách đơn hàng theo customerId
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    // Lấy thông tin khách hàng theo ID đơn hàng
    public Customer getCustomerByOrderId(Long order_id){
        Order order = orderRepository.getById(order_id);
        if(order != null) {
            return order.getCustomer();
        }
        throw new RuntimeException("Không tìm thấy đơn hàng với ID: " + order_id);
    }


}
