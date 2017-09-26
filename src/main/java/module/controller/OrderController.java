package module.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import module.bean.Customer;
import module.bean.Goods;
import module.bean.Orders;
import module.bean.Path;
import module.service.CustomerService;
import module.service.GoodsService;
import module.service.OrdersService;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/order")
public class OrderController
{
	@Resource
	public OrdersService ordersService;
	
	//删除
	@RequestMapping(value="/delete")
	public String delete(String id)
	{
		ordersService.delete(id);
		return "{\"status\":\"delete ok!\"}";
	}
	//查
	@RequestMapping(value="/getAll")
	public Iterable<Orders> getAll(String status)
	{
		Iterable<Orders> goods =  ordersService.findByStatus(status);
		return goods;
	}
	//查
	@RequestMapping(value="/findByType")
	public Iterable<Orders> findByType(String types)
	{
		Iterable<Orders> goods = ordersService.findByTypes(new ObjectId(types));
		return goods;
	}
	
	//查
	@RequestMapping(value="/findById")
	public Orders findById(String id)
	{
		return ordersService.findById(id);
	}
	
	/*@RequestMapping(value="/findByCustomerName2")
	public Customer findByCustomerName2(String CustomerName)
	{
		return carService.findByCustomerName2(CustomerName);
	}*/
}
