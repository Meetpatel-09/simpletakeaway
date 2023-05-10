package com.example.simpletakeaway.controller;

import com.example.simpletakeaway.model.Order;
import com.example.simpletakeaway.service.ItemService;
import com.example.simpletakeaway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ItemService itemService;

    @GetMapping({"/viewAllOrders"})
    public String ViewOrderList(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", service.getAllOrders());
        model.addAttribute("msq", message);
        model.addAttribute("total", service.getTodayTotal());

        return "ViewOrderList";
    }

    @GetMapping({"/addOrder"})
    public String addOrder(Model model) {
        Date date = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy-MM-dd");

        model.addAttribute("order", new Order());
        model.addAttribute("date", ft.format(date));
        model.addAttribute("list", itemService.getAllItems());
        return "AddOrder";
    }

    @PostMapping("/saveOrder")
    public String SaveOrder(Order order, RedirectAttributes redirectAttributes) {

        float price = itemService.getItemById(Integer.parseInt(order.getOrder_item_name())).getItem_price();
        String name = itemService.getItemById(Integer.parseInt(order.getOrder_item_name())).getItem_name();
        order.setOrder_item_price(price);
        order.setOrder_item_name(name);
        float total = price * order.getOrder_item_quantity();
        order.setOrder_total(total);
        Date date = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy-MM-dd");
        order.setOrder_date(date);

        if (service.saveOrUpdateItem(order)) {
            redirectAttributes.addFlashAttribute("message", "Save Successfully");
            return "redirect:/viewAllOrders";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addOrder";
    }
}
