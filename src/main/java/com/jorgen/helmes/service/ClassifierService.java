package com.jorgen.helmes.service;

import com.jorgen.helmes.domain.Classifier;
import com.jorgen.helmes.repository.ClassifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassifierService {
    private final ClassifierRepository classifierRepository;

    public Classifier getClassifier(long id) {
        return classifierRepository.getById(id);
    }
}
