package module.controller;

import java.util.Date;

import javax.annotation.Resource;

import module.bean.Classifies;
import module.service.ClassifiesService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/classify")
public class ClassifyController {

	@Resource
	public ClassifiesService cassifyService;
	
	//增
	@RequestMapping(value="/add")
	public String saveCustomer(String name,String remark)
	{
		if(null == name || null == remark) {
			return "reject";
		}
		Classifies classfy = new Classifies();
		classfy.setName(name);
		classfy.setRemark(remark);
		classfy.setCreate_at(new Date().getTime());
		classfy.setUpdate_at(new Date().getTime());
		System.out.println(classfy);
		cassifyService.save(classfy);
		return "{\"status\":\"add ok!\"}";
	}
	
	//删除
	@RequestMapping(value="/delete")
	public String delete(String id)
	{
		cassifyService.delete(id);
		return "{\"status\":\"delete ok!\"}";
	}
	
	//查
	@RequestMapping(value="/getAll")
	public Iterable<Classifies> getAll()
	{
		Iterable<Classifies> ret = cassifyService.getAll();
		return cassifyService.getAll();
	}
}
