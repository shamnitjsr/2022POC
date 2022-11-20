package in.shambhu.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import in.shambhu.command.api.command.CreateOrderCommand;
import in.shambhu.command.api.events.OrderCreatedEvent;

@Aggregate
public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;
	private String productId;
	private String userId;
	private String addressId;
	private Integer quantity;
	private String orderStatus;

	public OrderAggregate() {

	}

	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand) {

		// Validate The command

		OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
		BeanUtils.copyProperties(createOrderCommand, orderCreatedEvent);
		AggregateLifecycle.apply(orderCreatedEvent);

	}

	@EventSourcingHandler
	public void on(OrderCreatedEvent event) {

		this.orderStatus = event.getOrderStatus();
		this.userId = event.getUserId();
		this.orderId = event.getOrderId();
		this.quantity = event.getQuantity();
		this.productId = event.getProductId();
		this.addressId = event.getAddressId();
	}

}
