package module.service;


import javax.annotation.Resource;

import module.bean.Words;
import module.repository.WordsRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class WordsService
{
	@Resource
	private WordsRepository wordsRepository;
	
	
	//保存数据，@transactional为事务的绑定
	@Transactional
	public void save(Words custmr)
	{
		wordsRepository.save(custmr);
	}
	
	//删除数据
	@Transactional
	public void delete(String id)
	{
		wordsRepository.delete(id);
	}
	
	public Words findById(String id)
	{
		return wordsRepository.findOne(id);
	}
	
	//查询数据，无需添加事务
	public Iterable<Words> getAll()
	{
		return wordsRepository.findAll();	
	}
	
}

