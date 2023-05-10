package com.example.simpletakeaway.service;

import com.example.simpletakeaway.model.Order;
import com.example.simpletakeaway.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderService {

    @Autowired
    OrderRepo repo;

    public List<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        repo.findAll().forEach(order -> orders.add(order));
        return orders;
    }


    public Order getOrderById(int id) {
        return repo.findById(id).get();
    }

    public double getTodayTotal() {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        repo.findAll().forEach(order -> {
            Date date = new Date();
            SimpleDateFormat ft =
                    new SimpleDateFormat ("yyyy-MM-dd");
            if (ft.format(order.getOrder_date()).equals(ft.format(date)))  {
                total.set(order.getOrder_total() + total.get());
            }
        });
        return total.get();
    }

    public boolean saveOrUpdateItem(Order order) {
        Order updatedOrderObj =  repo.save(order);

        if (getOrderById(updatedOrderObj.getIdorder()) != null) {
            return true;
        }

        return false;
    }
}
