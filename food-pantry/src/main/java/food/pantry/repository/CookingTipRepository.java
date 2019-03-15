package food.pantry.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import food.pantry.model.CookingTip;

@RepositoryRestResource(collectionResourceRel = "cookingTip", path = "cookingTip")
public interface CookingTipRepository extends MongoRepository<CookingTip, Integer>{
	CookingTip findByid(Integer id);
	List<CookingTip> findByProductId(@Param("productId") Integer id);
}