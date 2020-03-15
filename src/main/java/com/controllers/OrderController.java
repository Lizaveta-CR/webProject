package com.controllers;

import com.domain.Order;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {
    OrderService orderService = new OrderServiceImpl();

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrders(Model model) {
        List<Order> orders = orderService.getAll();
        model.addAttribute("ordersList", orders);
        return "order";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if (error != null) {
            errorMessge = "Username or Password is incorrect !";
        }
        if (logout != null) {
            errorMessge = "You have been successfully logged out !";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }


    @RequestMapping(value = "/add-order", method = RequestMethod.GET)
    public String addOrderPage() {
        return "add-order";
    }

    @RequestMapping(value = "/add-order", method = RequestMethod.POST)
    public String addOrder(@RequestParam(value = "name") String name, @RequestParam(value = "price") String price) {
        try {
            Order order = new Order();
            if (name != null && name.matches("\\D*")) {
                order.setName(name);
            } else {
                return "error";
            }
            Double doublePrice = Double.valueOf(price);
            order.setPrice(doublePrice);

            orderService.save(order);
            return "order";

        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        Order orderById = orderService.getOrderById(id);

        orderService.delete(orderById);
        return "order";
    }

    @RequestMapping(value = "/edit-order/{id}")
    public String updateOrderPage(@PathVariable Integer id, Model model) {
        Order order = orderService.getOrderById(id);

        model.addAttribute("order", order);
        return "edit-form";
    }

    @RequestMapping(value = "/edit-order", method = RequestMethod.POST)
    public String updateOrder(@ModelAttribute("order") Order order) {
        try {
            order.getPrice();
            orderService.update(order);
            return "order";
        } catch (Exception e) {
            return "error";
        }
    }
}
