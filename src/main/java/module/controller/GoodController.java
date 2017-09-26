package module.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import module.bean.Customer;
import module.bean.Goods;
import module.bean.Path;
import module.service.CustomerService;
import module.service.GoodsService;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/good")
public class GoodController
{
	@Resource
	public GoodsService goodsService;
	
	//增
	@RequestMapping(value="/add")
	public String saveCustomer(String name, Double price ,
			String remark, String images, String types, String vedio,
			String img1, String img2, String img3)
	{
		if(null == name || null == images) {
			return "reject";
		}
		Goods good = new Goods();
		good.setCreate_at( new Date().getTime());
		good.setUpdate_at( new Date().getTime());
		good.setName(name);
		good.setRemark(remark);
		good.setVideo(vedio);
		
		List<String> list = new ArrayList<String>();
		list.add(images); 
		if(null != img1 && !img1.equals("undefined")) list.add(img1); 
		if(null != img2 && !img2.equals("undefined")) list.add(img2); 
		if(null != img3 && !img3.equals("undefined")) list.add(img3);
		good.setImages((String[]) list.toArray(new String[list.size()]));
		
		good.setTypes(new ObjectId(types));
		good.setPrice(price);
		goodsService.save(good);
		return "{\"status\":\"add ok!\"}";
	}
	//删除
	@RequestMapping(value="/delete")
	public String delete(String id)
	{
		goodsService.delete(id);
		return "{\"status\":\"delete ok!\"}";
	}
	//查
	@RequestMapping(value="/getAll")
	public Iterable<Goods> getAll()
	{
		return goodsService.getAll();
	}
	//查
	@RequestMapping(value="/findByType")
	public Iterable<Goods> findByType(String types)
	{
		Iterable<Goods> goods = goodsService.findByTypes(new ObjectId(types));
		System.out.println(goods);
		return goods;
	}
	
	//查
	@RequestMapping(value="/findById")
	public Goods findById(String id)
	{
		return goodsService.findById(id);
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
	public Page<Goods> getCustomerByParams(@PageableDefault(value = 2, sort = { "id" }, direction = Sort.Direction.DESC) 
    Pageable pageable) {//value是每页的对象个数，sort是排序的准则，direction指定是升序还是降序
		//如果不输入?page=0&size=4，默认为page=0，size=value
	    
	    return goodsService.getCustomerPage(pageable);
	}
	
	/*@RequestMapping(value="/findByCustomerName2")
	public Customer findByCustomerName2(String CustomerName)
	{
		return carService.findByCustomerName2(CustomerName);
	}*/
}
