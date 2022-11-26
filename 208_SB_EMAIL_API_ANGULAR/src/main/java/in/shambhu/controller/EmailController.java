package in.shambhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.shambhu.model.EmailRequest;
import in.shambhu.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping("/welcome")
	public String welcome() {
		return "This is my email api";
	}

	// api to send email

	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {

		System.out.println(emailRequest);
		boolean result = emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());
		if(result ) {
			return ResponseEntity.ok("Email is sent successfully...");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent ...");
		}
	}

}
