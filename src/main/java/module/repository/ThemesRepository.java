package module.repository;

import java.util.List;

import module.bean.Themes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThemesRepository extends MongoRepository<Themes, String>
{
	public List<Themes> findByTypes(ObjectId objectId);
}

