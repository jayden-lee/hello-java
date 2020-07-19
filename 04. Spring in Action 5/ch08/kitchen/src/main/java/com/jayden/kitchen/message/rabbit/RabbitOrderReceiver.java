package com.jayden.kitchen.message.rabbit;

import com.jayden.kitchen.domain.Order;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderReceiver {

    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter messageConverter;

    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageConverter = rabbitTemplate.getMessageConverter();
    }

    public Order receiveOrder() {
        Message message = rabbitTemplate.receive(30000L);
        return message != null
            ? (Order) messageConverter.fromMessage(message)
            : null;
    }
}
