package module.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import module.bean.Customer;
import module.bean.Words;
import module.service.CustomerService;
import module.service.WordsService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/word")
public class WordsController
{
	@Resource
	public WordsService wordsService;
	
	
	//增
	@RequestMapping(value="/add")
	public String saveCustomer(String name,String content,
			String pic1, String pic2, String pic3, String pic4, String pic5, String pic6,
			int order, double price, String cate, String id)
	{
		if(null == name || null == content) {
			return "reject";
		}
		Words word = new Words();
		word.setName(name);
		word.setContent(content);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH )+1;
		int data = cal.get(Calendar.DAY_OF_MONTH);
		StringBuilder sb = new StringBuilder().append(year).append("-").append(month).append("-").append(data);
		word.setDate(sb.toString());
		word.setDigest(cate);
		word.setPic1(pic1);
		word.setPic2(pic2);
		word.setPic3(pic3);
		word.setPic4(pic4);
		word.setPic5(pic5);
		word.setPic6(pic6);
		word.setPrice(price);
		word.setRate(order);
		if(!id.equals("undefined")) {
			word.setId(id);
			wordsService.update(word);
		} else {
			wordsService.save(word);
		}
		return "{\"status\":\"add ok!\"}";
	}
	//删除
	@RequestMapping(value="/delete")
	public String delete(String id)
	{
		wordsService.delete(id);
		return "{\"status\":\"delete ok!\"}";
	}
	//查
	@RequestMapping(value="/getAll")
	public Iterable<Words> getAll()
	{
		return wordsService.getAll();
	}
}
