package com.jorgen.helmes.repository;

import com.jorgen.helmes.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
