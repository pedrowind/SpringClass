package com.devsuperior.aula.entities;

import java.util.Random;

public class Order {
    private Integer code;
    private Double basic;
    private Integer discount;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    public Order() {
        Random random = new Random();
        this.code = random.nextInt(1000);
        this.basic = random.nextDouble(500);
        this.discount = random.nextInt(36);
    }
}
