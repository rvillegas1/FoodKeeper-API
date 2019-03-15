package food.pantry.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import food.pantry.model.Category;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends MongoRepository<Category, Integer>{
	Category findByid(Integer id);
	List<Category> findByName(@Param("name") String name);
}