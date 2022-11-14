package in.shambhu;

import lombok.Data;

@Data
public class WelcomeResponse {

	private String greetMsg;
	private String welcomeMSg;
	private Pet pet;
}
