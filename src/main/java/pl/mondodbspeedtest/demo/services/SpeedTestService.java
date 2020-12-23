package pl.mondodbspeedtest.demo.services;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.mondodbspeedtest.demo.aspects.PersonAspect;
import pl.mondodbspeedtest.demo.models.Person;
import pl.mondodbspeedtest.demo.models.PersonSQL;
import pl.mondodbspeedtest.demo.repositories.PersonRepository;
import pl.mondodbspeedtest.demo.repositories.PersonSQLRepo;

import java.util.List;

@Component
public class SpeedTestService {
    private ReadFileService readFileService;
    private PersonRepository personRepository;
    private PersonSQLRepo personSQLRepo;
    @Autowired
    public SpeedTestService(ReadFileService readFileService, PersonRepository personRepository, PersonSQLRepo personSQLRepo) {
        this.readFileService = readFileService;
        this.personRepository = personRepository;
        this.personSQLRepo = personSQLRepo;
    }
    @EventListener(ApplicationReadyEvent.class)
    @PersonAspect
    public void saveMysqlSpeed(){
        List<PersonSQL> people = readFileService.readFileMethodPersonSQL();
        personSQLRepo.saveAll(people);
        System.out.print("save SQL: ");
    }
    @EventListener(ApplicationReadyEvent.class)
    @PersonAspect
    public void readMysqlSpeed(){
        List<PersonSQL> personSQLS = personSQLRepo.findAll();
        System.out.print("read SQL: ");
    }
    @EventListener(ApplicationReadyEvent.class)
    @PersonAspect
    public void saveMongoDBSpeed(){
        personRepository.saveAll(readFileService.readFileMethodPerson());
        System.out.print("save Mongo: ");
    }
    @EventListener(ApplicationReadyEvent.class)
    @PersonAspect
    public void readMongoDBSpeed(){
        List<Person> people = personRepository.findAll();
        System.out.print("read Mongo: ");
    }
}
