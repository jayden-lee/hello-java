package com.jayden.kitchen.message.rabbit.listener;

import com.jayden.kitchen.KitchenUI;
import com.jayden.kitchen.domain.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    private KitchenUI ui;

    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @RabbitListener
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }
}
