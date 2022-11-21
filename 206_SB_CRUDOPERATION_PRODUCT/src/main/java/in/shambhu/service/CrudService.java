package in.shambhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shambhu.model.Product;
import in.shambhu.repository.CrudOperationInterface;

@Service
public class CrudService {
	
	@Autowired
	private CrudOperationInterface repo;
	
	public Product create(Product product) {
		return repo.save(product);
	}
	
	public List<Product> read(){
		return repo.findAll();
	}
	
	public Product update(Product product) {
		return repo.save(product);
	}
	
	public void delete(Product product) {
		repo.delete(product);
	}

}
