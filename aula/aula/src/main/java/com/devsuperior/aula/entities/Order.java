package com.devsuperior.aula.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Order {
    private Integer code;
    private Double basic;
    private Integer discount;

    public Order() {
        Random random = new Random();
        this.code = random.nextInt(1000);
        this.basic = random.nextDouble(500);
        this.discount = random.nextInt(36);
    }
}
