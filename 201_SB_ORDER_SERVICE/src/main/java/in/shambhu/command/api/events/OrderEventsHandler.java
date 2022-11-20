package in.shambhu.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import in.shambhu.command.api.data.Order;
import in.shambhu.command.api.data.OrderRepository;

@Component
public class OrderEventsHandler {

	private OrderRepository orderRepository;

	public OrderEventsHandler(OrderRepository orderRepository) {

		this.orderRepository = orderRepository;
	}

	@EventHandler
	public void on(OrderCreatedEvent event) {

		Order order = new Order();
		BeanUtils.copyProperties(event, order);
		orderRepository.save(order);
	}
}
