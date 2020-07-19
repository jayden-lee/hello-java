package com.jayden.jms.message;

import com.jayden.jms.domain.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
