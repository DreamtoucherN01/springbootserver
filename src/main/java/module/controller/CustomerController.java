package module.controller;


import javax.annotation.Resource;

import module.bean.Customer;
import module.service.CustomerService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController
{
	@Resource
	public CustomerService CustomerService;
	
	
	//增
	@RequestMapping(value="/add")
	public String saveCustomer(String id,String firstName,String lastName)
	{
		if(null == firstName || null == lastName) {
			return "reject";
		}
		Customer Customer = new Customer(firstName,lastName);
		Customer.setId(id);
		CustomerService.save(Customer);
		return "{\"status\":\"add ok!\"}";
	}
	//删除
	@RequestMapping(value="/delete")
	public String delete(String id)
	{
		CustomerService.delete(id);
		return "{\"status\":\"delete ok!\"}";
	}
	//查
	@RequestMapping(value="/getAll")
	public Iterable<Customer> getAll()
	{
		return CustomerService.getAll();
	}
	//改
	@RequestMapping(value="/editName")
	public String editCustomerName(String id, String firstName, String lastName)
	{
		Customer c = CustomerService.findById(id);
		c.setFirstName(firstName);
		c.setLastName(lastName);
		CustomerService.save(c);
		return "{\"status\":\"edit ok!\"}";
	}
	//查
	@RequestMapping(value="/findByFirstName")
	public Iterable<Customer> findByFirstName(String firstName)
	{
		return CustomerService.findByFirstName(firstName);
	}
	
	@RequestMapping(value="/findByLastName")
	public Iterable<Customer> findByLastName(String lastName)
	{
		return CustomerService.findByLastName(lastName);
	}
	//查
	@RequestMapping(value="/findById")
	public Customer findById(String id)
	{
		return CustomerService.findById(id);
	}
	//查
	/*@RequestMapping(value = "/getCustomerPage1", method=RequestMethod.GET,produces="text/json;charset=UTF-8")
	public Page<Customer> getCustomerByParams(@RequestParam(value = "page", defaultValue = "0") int page,
	        @RequestParam(value = "size", defaultValue = "7") int size) {
	    Sort sort = new Sort(Direction.ASC, "id");//根据id升序
	    
	    Pageable pageable = new PageRequest(page, size, sort);
	    
	    return CustomerService.getCustomerPage(pageable);
	}*/
	
	@RequestMapping(value = "/getCustomerPage", method=RequestMethod.GET)//,produces="text/json;charset=UTF-8")
	public Page<Customer> getCustomerByParams(@PageableDefault(value = 2, sort = { "id" }, direction = Sort.Direction.DESC) 
    Pageable pageable) {//value是每页的对象个数，sort是排序的准则，direction指定是升序还是降序
		//如果不输入?page=0&size=4，默认为page=0，size=value
	    
	    return CustomerService.getCustomerPage(pageable);
	}
	
	/*@RequestMapping(value="/findByCustomerName2")
	public Customer findByCustomerName2(String CustomerName)
	{
		return carService.findByCustomerName2(CustomerName);
	}*/
}
