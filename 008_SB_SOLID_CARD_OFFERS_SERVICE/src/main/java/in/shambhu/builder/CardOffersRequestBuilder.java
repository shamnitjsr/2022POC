package in.shambhu.builder;

import in.shambhu.model.CardOffersRequest;
import in.shambhu.model.CardOffersServiceRequest;

public class CardOffersRequestBuilder {

	public CardOffersServiceRequest buildServiceReq(CardOffersRequest request) {

		CardOffersServiceRequest svcRequest = new CardOffersServiceRequest();

		svcRequest.setCardNum(request.getCardNum());
		svcRequest.setCvv(request.getCvv());
		svcRequest.setNameOfCards("Shambhu");

		return svcRequest;
	}

}
