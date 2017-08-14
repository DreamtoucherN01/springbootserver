package module.repository;

import java.util.List;

import module.bean.Classifies;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassifiesRepository extends MongoRepository<Classifies, String>{

	public List<Classifies> findByName(String name);
}
