package in.shambhu.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import in.shambhu.command.ValidatePaymentCommand;
import in.shambhu.command.events.PaymentProcessedEvent;
import lombok.extern.slf4j.Slf4j;

@Aggregate
@Slf4j
public class PaymentAggregate {

	@AggregateIdentifier
	private String paymentId;
	private String orderId;
	private String paymentStatus;

	public PaymentAggregate() {

	}

	@CommandHandler
	public PaymentAggregate(ValidatePaymentCommand validatePaymentCommand) {

		// Validate the payment details
		// publish the payment process event
		log.info("Executing ValidatePaymentCommand for " + "Order Id: {} and Payment Id: {}",
				validatePaymentCommand.getOrderId(), validatePaymentCommand.getPaymentId());

		PaymentProcessedEvent paymentProcessedEvent = new PaymentProcessedEvent(validatePaymentCommand.getPaymentId(),
				validatePaymentCommand.getOrderId());
		AggregateLifecycle.apply(paymentProcessedEvent);
		log.info("PaymentProcessedEvent Appliyed");
	}

	public void on(PaymentProcessedEvent event) {
		this.paymentId = paymentId;
		this.orderId = orderId;

	}

}
