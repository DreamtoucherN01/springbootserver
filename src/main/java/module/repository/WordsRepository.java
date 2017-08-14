package module.repository;

import module.bean.Words;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WordsRepository extends MongoRepository<Words, String>
{
}

