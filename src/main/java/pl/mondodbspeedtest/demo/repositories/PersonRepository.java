package pl.mondodbspeedtest.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.mondodbspeedtest.demo.models.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {
}
