package in.shambhu.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDetails {

	private String name;
	private String cardNumber;
	private Integer validateUntilMonth;
	private Integer validUntillYear;
	private Integer cvv;

}
