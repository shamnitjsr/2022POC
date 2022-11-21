package in.shambhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shambhu.model.Product;

@Repository
public interface CrudOperationInterface extends JpaRepository<Product, Integer>{

}
