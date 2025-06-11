package com.devsuperior.aula;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.service.OrderService;
import com.devsuperior.aula.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShippingService shippingService;

    public static void main(String[] args) {
      	SpringApplication.run(AulaApplication.class, args);
    }

	@Override
	public void run(String... args) {
		Order order = new Order();
		Double total = orderService.total(order);
		Double shipping = shippingService.calculateShipping(order.getBasic());

		System.out.println("Preço inicial: " + String.format("%.2f", order.getBasic()));
		System.out.println("Total do pedido: " + String.format("%.2f", total));
		System.out.println("Total do desconto: " + order.getDiscount() + "%");
		System.out.println("Total do frete: " + String.format("%.2f", shipping));
	}
}
