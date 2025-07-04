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
		Order order1 = new Order(1034, 150.0, 20);
		System.out.println("Pedido código " + order1.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order1));

		Order order2 = new Order(2282, 800.0, 10);
		System.out.println("Pedido código " + order2.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order2));

		Order order3 = new Order(1309, 95.90, 0);
		System.out.println("Pedido código " + order3.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order3));
	}
}
