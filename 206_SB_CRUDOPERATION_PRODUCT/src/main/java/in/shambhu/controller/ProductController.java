package in.shambhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shambhu.model.Product;
import in.shambhu.service.CrudService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private CrudService crudService;

	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {

		return crudService.create(product);
	}

	@GetMapping("/list")
	public List<Product> getAll() {
		return crudService.read();
	}

	@PutMapping("/update")
	public Product update(@RequestBody Product product) {

		return crudService.update(product);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody Product product) {

		crudService.delete(product);

	}

}
