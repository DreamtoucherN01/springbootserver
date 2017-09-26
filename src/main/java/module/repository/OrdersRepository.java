package module.repository;

import java.util.List;

import module.bean.Goods;
import module.bean.Orders;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersRepository extends MongoRepository<Orders, String>
{
	public List<Orders> findByTypes(ObjectId objectId);
	
	public List<Orders> findByStatus(String status);
}

