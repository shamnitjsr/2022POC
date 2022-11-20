package in.shambhu.projection;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import in.shambhu.model.CardDetails;
import in.shambhu.model.User;
import in.shambhu.queries.GetUserPaymentDetailsQuery;

@Component
public class UserProjection {

	@QueryHandler
	public User getUserPaymentDetails(GetUserPaymentDetailsQuery query) {

		// Ideally Get the Details from the DB
		CardDetails cardDetails = CardDetails.builder().name("Shambhu").validUntillYear(2022).validateUntilMonth(01)
				.cardNumber("123456789").cvv(123).build();
		return User.builder().userId(query.getUserId()).firstName("Shambhu").lastName("Kumar").cardDetails(cardDetails)

				.build();

	}

}
