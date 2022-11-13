package in.shambhu.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome to AshokIT...!!!";
	}

}
