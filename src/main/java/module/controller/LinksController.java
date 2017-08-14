package module.controller;


import javax.annotation.Resource;

import module.bean.Customer;
import module.bean.Links;
import module.service.CustomerService;
import module.service.LinksService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/link")
public class LinksController
{
	@Resource
	public LinksService linksService;
	
	
	//增
	@RequestMapping(value="/add")
	public String saveCustomer(String name,String pic,String link2)
	{
		if(null == name || null == pic) {
			return "reject";
		}
		Links link = new Links();
		link.setTag(name);
		link.setUrl(pic);
		link.setContentUrl(link2);
		linksService.save(link);
		return "{\"status\":\"add ok!\"}";
	}
	//删除
	@RequestMapping(value="/delete")
	public String delete(String id)
	{
		linksService.delete(id);
		return "{\"status\":\"delete ok!\"}";
	}
	//查
	@RequestMapping(value="/getAll")
	public Iterable<Links> getAll()
	{
		return linksService.getAll();
	}
}
