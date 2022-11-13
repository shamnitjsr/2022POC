package in.shambhu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shambhu.model.Book;
import in.shambhu.repository.BookRepository;

@RestController
public class BookRestController {

	@Autowired
	private BookRepository bookRepo;

	@PostMapping("/saveBook")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		bookRepo.save(book);

		return new ResponseEntity<>("Book Saved", HttpStatus.OK);
	}

	@GetMapping("/getAllBooks")
	public List<Book> books() {

		return bookRepo.findAll();

	}

	@GetMapping("/book/{bookId}")
	public Book getBookById(@PathVariable Integer bookId) {

		return bookRepo.findByBookId(bookId);
	}

	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable String id) {

		bookRepo.deleteById(id);
		return "Deleted Successfully";

	}

}
