package com.jorgen.helmes.repository;

import com.jorgen.helmes.domain.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassifierRepository extends JpaRepository<Classifier, Long> {
}
