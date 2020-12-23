package pl.mondodbspeedtest.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mondodbspeedtest.demo.models.PersonSQL;

@Repository
public interface PersonSQLRepo extends JpaRepository<PersonSQL,Long> {
}
