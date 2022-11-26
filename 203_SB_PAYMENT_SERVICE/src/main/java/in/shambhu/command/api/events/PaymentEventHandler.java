package in.shambhu.command.api.events;

import java.util.Date;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import in.shambhu.command.api.data.Payment;
import in.shambhu.command.api.data.PaymentRepository;
import in.shambhu.command.events.PaymentProcessedEvent;

@Component
public class PaymentEventHandler {

	private PaymentRepository paymentRepository;

	public PaymentEventHandler(PaymentRepository paymentRepository) {

		this.paymentRepository = paymentRepository;

	}

	@EventHandler
	public void on(PaymentProcessedEvent event) {

		Payment payment = Payment.builder().paymentId(event.getPaymentId()).orderId(event.getOrderId())
				.paymentStatus("COMPLETED").timeStamp(new Date()).build();
		paymentRepository.save(payment);

	}

}
