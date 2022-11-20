package in.shambhu.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shambhu.command.api.command.CreateOrderCommand;
import in.shambhu.command.api.model.OrderRestModel;

@RestController
@RequestMapping("/oders")
public class OrderCommandController {

	private CommandGateway commandGateway;

	public OrderCommandController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping
	public String createOrder(@RequestBody OrderRestModel orderRestModel) {
		String orderId = UUID.randomUUID().toString();
		CreateOrderCommand createOrderCommand = CreateOrderCommand.builder().orderId(orderId)
				.addressId(orderRestModel.getAddressId()).productId(orderRestModel.getAddressId())
				.quantity(orderRestModel.getQuantity()).orderStatus("CREATED").build();

		commandGateway.sendAndWait(createOrderCommand);

		return "Order Created";
	}

}
