package com.jorgen.helmes.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jorgen.helmes.ClassifierRequest;
import com.jorgen.helmes.domain.Classifier;
import com.jorgen.helmes.rabbit.RabbitMQService;
import com.jorgen.helmes.repository.ClassifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClassificationController {
    private final ClassifierRepository classifierRepository;
    private final RabbitMQService rabbitMQService;

    @GetMapping("/classifications")
    public List<Classifier> getClassifications() {
        return classifierRepository.findAll();
    }

    @GetMapping("/classification")
    public Classifier getClassification(@RequestParam long id) {
        return classifierRepository.getById(id);
    }

    @PostMapping("/classification")
    public void saveClassification(@RequestBody ClassifierRequest classifier) throws JsonProcessingException {
        rabbitMQService.sendMessage("queue", classifier);
    }
}
