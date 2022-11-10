package in.shambhu;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shambhu.book.repository.BookRepository;
import in.shambhu.model.book.Book;
import in.shambhu.model.user.User;
import in.shambhu.user.repository.UserRepository;

@SpringBootApplication
@RestController

public class Application {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void addData2DB() {

		userRepository.saveAll(Stream.of(new User(744, "John"), new User(787, "Pitter")).collect(Collectors.toList()));
		bookRepository.saveAll(
				Stream.of(new Book(213, "core java"), new Book(898, "SpringBoot")).collect(Collectors.toList()));

	}

	@GetMapping("/user")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/book")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
