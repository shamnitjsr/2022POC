package in.shambhu.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	
	@GetMapping("/home")
	public String home() {
		
		String msg = "Welcome to Shambhu IT Bank...!!!";
		return msg;
	}
	
	@GetMapping("/balance")
	public String getBalance() {
		
		String msg = "Welcome current balance is : 4567 INR";
		return msg;
	}
	
	@GetMapping("/statement")
	public String getStmt() {
		
		String msg = "Your Statement Generated and sent to your email id";
		return msg;
	}
	
	@GetMapping("/contact")
	public String contact() {
		
		String msg = "ThankYou for connecting customer support, we will get back to you";
		return msg;
	}

}
