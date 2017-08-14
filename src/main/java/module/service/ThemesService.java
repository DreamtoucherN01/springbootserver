package module.service;


import java.util.List;

import javax.annotation.Resource;

import module.bean.Themes;
import module.repository.ThemesRepository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ThemesService
{
	@Resource
	private ThemesRepository themesRepository;
	
	
	//保存数据，@transactional为事务的绑定
	@Transactional
	public void save(Themes custmr)
	{
		themesRepository.save(custmr);
	}
	
	//删除数据
	@Transactional
	public void delete(String id)
	{
		themesRepository.delete(id);
	}
	
	public Themes findById(String id)
	{
		return themesRepository.findOne(id);
	}
	
	//查询数据，无需添加事务
	public Iterable<Themes> getAll()
	{
		return themesRepository.findAll();	
	}
	
	public List<Themes> findByTypes(ObjectId objectId)
	{
		return themesRepository.findByTypes(objectId);
	}
	
	public Page<Themes> getCustomerPage(Pageable pageable)
	{
		return themesRepository.findAll(pageable);
	}
	
}

