package module.repository;

import module.bean.Links;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinksRepository extends MongoRepository<Links, String>
{
	
}

