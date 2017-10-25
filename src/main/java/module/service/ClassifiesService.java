package module.service;

import javax.annotation.Resource;

import module.bean.Classifies;
import module.repository.ClassifiesRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClassifiesService{

	@Resource
	private ClassifiesRepository classifiesRepository;
	
	@Transactional
	public void save(Classifies classfy)
	{
		classifiesRepository.save(classfy);
	}
	
	@Transactional
	public void update(Classifies classfy)
	{
		classifiesRepository.delete(classfy.getObjectId());
		classifiesRepository.save(classfy);
	}
	
	//删除数据
	@Transactional
	public void delete(String id)
	{
		classifiesRepository.delete(id);
	}
	
	//查询数据，无需添加事务
	public Iterable<Classifies> getAll()
	{
		return classifiesRepository.findAll();	
	}
	
}
