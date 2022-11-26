package in.shambhu.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipOrderCommand {

	@TargetAggregateIdentifier
	private String shipmentId;
	private String orderid;
	
}
