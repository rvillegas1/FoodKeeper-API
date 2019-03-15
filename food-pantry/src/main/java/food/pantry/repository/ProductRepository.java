package food.pantry.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import food.pantry.model.Product;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends MongoRepository<Product, Integer>{
	Product findByid(Integer id);
	List<Product> findByName(@Param("name") String name);
	List<Product> findByCategoryId(@Param("categoryId") Integer id);
}
