package com.example.Test1.Controllers;

import com.example.Test1.Models.OrderProps;
import com.example.Test1.Models.Orders;
import com.example.Test1.Repositories.OrdersRepository;
import com.example.Test1.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import com.example.Test1.Models.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/orders")
@SessionAttributes({"order", "user"})
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrdersRepository orderRepo;
    private final OrderProps props;
    private final UsersRepository userRepo;

    @GetMapping("/current")
    public String orderForm(Model model, Principal principal) {

        log.info("   --- Current order");

        Users user = userRepo.findByUsername(principal.getName());
        System.out.println(user.getFullname());
        Orders order = new Orders();

        model.addAttribute("user", user);
        model.addAttribute("order", order);

        return "orderForm";
    }

    @PostMapping("/processOrder")
    public String processOrder(@Valid Orders order, Errors errors,
                               SessionStatus sessionStatus, Principal principal) {

        Users user = userRepo.findByUsername(principal.getName());

        order.setUserId(user);

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "orderForm";
        }


        log.info("-- Process Order");
        System.out.println(order.getCcCVV() + " " + order.getUserId().getFullname() + " " + order.getUserId().getPhoneNumber());
        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/orders/all";
    }

    @GetMapping("/all")
    public String ordersForUser(Principal principal, Model model) {

        Pageable pageable = PageRequest.of(0, props.getPageSize());

        Users user = userRepo.findByUsername(principal.getName());

        model.addAttribute("user", user);

        Page<Orders> ordersPage = orderRepo.findByUserIdOrderByPlacedAtDesc(user, pageable);
        model.addAttribute("ordersPage", ordersPage);

        return "orderList";
    }
}