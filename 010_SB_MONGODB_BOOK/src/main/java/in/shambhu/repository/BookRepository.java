package in.shambhu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.shambhu.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

	public Book findByBookId(Integer bookId);

}
