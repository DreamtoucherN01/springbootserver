package module.service;


import java.util.List;

import javax.annotation.Resource;

import module.bean.Customer;
import module.repository.CustomerRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CustomerService
{
	@Resource
	private CustomerRepository CustomerRepository;
	
	
	//保存数据，@transactional为事务的绑定
	@Transactional
	public void save(Customer custmr)
	{
		CustomerRepository.save(custmr);
	}
	
	//删除数据
	@Transactional
	public void delete(String id)
	{
		CustomerRepository.delete(id);
	}
	
	public Customer findById(String id)
	{
		return CustomerRepository.findOne(id);
	}
	
	//查询数据，无需添加事务
	public Iterable<Customer> getAll()
	{
		return CustomerRepository.findAll();	
	}
	
	public List<Customer> findByFirstName(String firstName)
	{
		return CustomerRepository.findByFirstName(firstName);
	}
	
	public List<Customer> findByLastName(String lastName)
	{
		return CustomerRepository.findByLastName(lastName);
	}
	
	public Page<Customer> getCustomerPage(Pageable pageable)
	{
		return CustomerRepository.findAll(pageable);
	}
	
}

