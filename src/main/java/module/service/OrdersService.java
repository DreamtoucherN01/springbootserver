package module.service;


import java.util.List;

import javax.annotation.Resource;

import module.bean.Customer;
import module.bean.Goods;
import module.bean.Orders;
import module.repository.CustomerRepository;
import module.repository.GoodsRepository;
import module.repository.OrdersRepository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class OrdersService
{
	@Resource
	private OrdersRepository orderRepository;
	
	
	//保存数据，@transactional为事务的绑定
	@Transactional
	public void save(Orders custmr)
	{
		orderRepository.save(custmr);
	}
	
	//删除数据
	@Transactional
	public void delete(String id)
	{
		orderRepository.delete(id);
	}
	
	public Orders findById(String id)
	{
		return orderRepository.findOne(id);
	}
	
	//查询数据，无需添加事务
	public Iterable<Orders> getAll()
	{
		return orderRepository.findAll();	
	}
	
	public List<Orders> findByTypes(ObjectId objectId)
	{
		return orderRepository.findByTypes(objectId);
	}
	
	public List<Orders> findByStatus(String status)
	{
		return orderRepository.findByStatus(status);
	}
	
	public Page<Orders> getCustomerPage(Pageable pageable)
	{
		return orderRepository.findAll(pageable);
	}
	
}

