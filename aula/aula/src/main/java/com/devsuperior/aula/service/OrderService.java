package com.devsuperior.aula.service;

import com.devsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public Double total(Order order) {
        Double shipping = shippingService.calculateShipping(order.getBasic());
        return order.getBasic() * (1 - order.getDiscount() / 100.0) + shipping;
    }
}
