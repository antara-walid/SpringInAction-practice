package com.example.tacos.web;


import com.example.tacos.TacoOrder;
import com.example.tacos.User;
import com.example.tacos.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j // for logging
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder") // tacoOrder should be kept in the session
public class OrderController {
    private OrderRepository orderRepo;
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus,@AuthenticationPrincipal User user) {
        if(errors.hasErrors())
            return "orderForm";

        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete(); // the setComplete methode of session status clean the session
        return "redirect:/";
    }
}
