package module.controller;


import javax.annotation.Resource;

import module.bean.Themes;
import module.service.ThemesService;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/theme")
public class ThemesController
{
	@Resource
	public ThemesService themesService;
	
//	var url = "/theme/add?name="+$scope.name+"&subname="+$scope.subname
//			+"&content="+$scope.content+"&pic1="+$scope.pic1
//			+"&pic2="+$scope.pic2+"&pic3="+$scope.pic3
//			+"&types="+params['id'];
	//增
	@RequestMapping(value="/add")
	public String saveCustomer(String name, String subname ,
			String content, String pic1, String pic2, String pic3, String types)
	{
		if(null == name || null == subname 
				|| null == content || null == types) {
			return "reject";
		}
		Themes themes = new Themes();
		themes.setName(name);
		themes.setSubname(subname);
		themes.setContent(content);
		themes.setTypes(new ObjectId(types));
		themes.setPic1(pic1);
		themes.setPic2(pic2);
		themes.setPic3(pic3);
		themesService.save(themes);
		return "{\"status\":\"add ok!\"}";
	}
	//删除
	@RequestMapping(value="/delete")
	public String delete(String id)
	{
		themesService.delete(id);
		return "{\"status\":\"delete ok!\"}";
	}
	//查
	@RequestMapping(value="/getAll")
	public Iterable<Themes> getAll()
	{
		return themesService.getAll();
	}
	//查
	@RequestMapping(value="/findByType")
	public Iterable<Themes> findByType(String types)
	{
		Iterable<Themes> themes = themesService.findByTypes(new ObjectId(types));
		System.out.println(themes);
		return themes;
	}
	
	//查
	@RequestMapping(value="/findById")
	public Themes findById(String id)
	{
		return themesService.findById(id);
	}

}
