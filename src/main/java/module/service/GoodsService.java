package module.service;


import java.util.List;

import javax.annotation.Resource;

import module.bean.Customer;
import module.bean.Goods;
import module.repository.CustomerRepository;
import module.repository.GoodsRepository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class GoodsService
{
	@Resource
	private GoodsRepository goodRepository;
	
	
	//保存数据，@transactional为事务的绑定
	@Transactional
	public void save(Goods custmr)
	{
		goodRepository.save(custmr);
	}
	
	//删除数据
	@Transactional
	public void delete(String id)
	{
		goodRepository.delete(id);
	}
	
	public Goods findById(String id)
	{
		return goodRepository.findOne(id);
	}
	
	//查询数据，无需添加事务
	public Iterable<Goods> getAll()
	{
		return goodRepository.findAll();	
	}
	
	public List<Goods> findByTypes(ObjectId objectId)
	{
		return goodRepository.findByTypes(objectId);
	}
	
	public Page<Goods> getCustomerPage(Pageable pageable)
	{
		return goodRepository.findAll(pageable);
	}
	
}

