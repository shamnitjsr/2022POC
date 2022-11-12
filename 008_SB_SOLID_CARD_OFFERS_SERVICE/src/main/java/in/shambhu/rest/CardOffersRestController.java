package in.shambhu.rest;

import org.springframework.web.bind.annotation.RestController;

import in.shambhu.builder.CardOffersRequestBuilder;
import in.shambhu.builder.CardOffersResponseBuilder;
import in.shambhu.model.CardOffersRequest;
import in.shambhu.model.CardOffersResponse;
import in.shambhu.model.CardOffersServiceRequest;
import in.shambhu.model.CardOffersServiceResponse;
import in.shambhu.service.CardOffersService;
import in.shambhu.validator.CardOffersValidator;

@RestController
public class CardOffersRestController {

	public CardOffersResponse getOffers(CardOffersRequest request) {

		// 1. get the request from client

		// 2.validate the request ---------100 lines of code

		CardOffersValidator validator = new CardOffersValidator();
		validator.validateRequest(request);

		// 3. prepare the request for service class

		CardOffersRequestBuilder reqBuilder = new CardOffersRequestBuilder();
		CardOffersServiceRequest svcRequest = reqBuilder.buildServiceReq(request);

		// 4. call service class
		CardOffersService service = new CardOffersService();
		CardOffersServiceResponse response = service.getOffers(svcRequest);

		// 5.prepare the controller response

		CardOffersResponseBuilder respBuilder = new CardOffersResponseBuilder();
		CardOffersResponse offerResp = respBuilder.buildControllerResp(response);


		return offerResp;
	}

}
