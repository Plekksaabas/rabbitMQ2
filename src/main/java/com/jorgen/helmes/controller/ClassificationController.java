package com.jorgen.helmes.controller;

import com.jorgen.helmes.domain.Classifier;
import com.jorgen.helmes.repository.ClassifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClassificationController {
    private final ClassifierRepository classifierRepository;

    @GetMapping("/classifications")
    public List<Classifier> getClassifications() {
        return classifierRepository.findAll();
    }

    @GetMapping("/classification")
    public Classifier getClassification(@RequestParam long id) {
        return classifierRepository.getById(id);
    }
}
