package in.shambhu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeRestController {

	private Logger logger = LoggerFactory.getLogger(WelcomeRestController.class);

	@Autowired
	private GreetClient greetClient;

	@GetMapping("/welcome")
	public String welcomeMsg() {

		logger.info("welcomeMsg() execution - start");

		String welcomeMsg = "Welcome to Ashok IT..!!";

		// Inter service communication
		String greetMsg = greetClient.invokeGreetApi();

		// External service communication

		RestTemplate rt = new RestTemplate();
		String endPointUrl = "www.amazon.com/pet";

		ResponseEntity<Pet> entity = rt.getForEntity(endPointUrl, Pet.class);

		Pet petData = entity.getBody();

		logger.info("welcomeMsg() execution - end ");

		WelcomeResponse finalResponse = new WelcomeResponse();

		finalResponse.setGreetMsg(greetMsg);
		finalResponse.setWelcomeMSg(welcomeMsg);
		finalResponse.setPet(petData);

		return greetMsg + ", " + welcomeMsg + ",";
	}
}
