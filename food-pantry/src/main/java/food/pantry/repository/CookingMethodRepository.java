package food.pantry.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import food.pantry.model.CookingMethod;

@RepositoryRestResource(collectionResourceRel = "cookingMethod", path = "cookingMethod")
public interface CookingMethodRepository extends MongoRepository<CookingMethod, Integer>{
	CookingMethod findByid(Integer id);
	List<CookingMethod> findByProductId(@Param("productId") Integer id);
	List<CookingMethod> findByMethod(@Param("method") String method);
}