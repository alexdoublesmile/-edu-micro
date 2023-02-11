package edu.joyful.micro.repository;

import edu.joyful.micro.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
