package module.repository;

import java.util.List;

import module.bean.Goods;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoodsRepository extends MongoRepository<Goods, String>
{
	public List<Goods> findByTypes(ObjectId objectId);
}

