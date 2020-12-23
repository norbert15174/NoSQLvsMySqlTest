package pl.mondodbspeedtest.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.mondodbspeedtest.demo.models.Person;
import pl.mondodbspeedtest.demo.models.PersonSQL;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Service
public class ReadFileService {

    public ReadFileService() {
    }

    public Person splitDataPerson(String s){
        String[] item = s.split(",");
        return new Person(item[1],item[2],item[3],item[4],item[5]);
    }

    public PersonSQL splitDataPersonSQL(String s) {
        String[] item = s.split(",");
        return new PersonSQL(item[1], item[2], item[3], item[4], item[5]);
    }

    public List<Person> readFileMethodPerson(){
        List<Person> people = new ArrayList<>();
        File file = new File("src\\main\\resources\\MOCK_DATA.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                people.add(splitDataPerson(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return people;

    }

    public List<PersonSQL> readFileMethodPersonSQL(){
        List<PersonSQL> people = new ArrayList<>();
        File file = new File("src\\main\\resources\\MOCK_DATA.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                people.add(splitDataPersonSQL(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return people;

    }


}
