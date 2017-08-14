package module.service;


import javax.annotation.Resource;

import module.bean.Links;
import module.repository.LinksRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class LinksService
{
	@Resource
	private LinksRepository linksRepository;
	
	
	//保存数据，@transactional为事务的绑定
	@Transactional
	public void save(Links link)
	{
		linksRepository.save(link);
	}
	
	//删除数据
	@Transactional
	public void delete(String id)
	{
		linksRepository.delete(id);
	}
	
	public Links findById(String id)
	{
		return linksRepository.findOne(id);
	}
	
	//查询数据，无需添加事务
	public Iterable<Links> getAll()
	{
		return linksRepository.findAll();	
	}
	

}

