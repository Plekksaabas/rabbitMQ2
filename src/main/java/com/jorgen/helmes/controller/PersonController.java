package com.jorgen.helmes.controller;

import com.jorgen.helmes.domain.ClassifierChoice;
import com.jorgen.helmes.domain.Person;
import com.jorgen.helmes.dto.PersonChoiceSaveRequest;
import com.jorgen.helmes.repository.ClassifierChoiceRepository;
import com.jorgen.helmes.repository.PersonRepository;
import com.jorgen.helmes.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;
    private final PersonService personService;
    private final ClassifierChoiceRepository classifierChoiceRepository;

    @GetMapping
    public Person getPerson(@RequestParam long id) {
        return personRepository.getById(id);
    }

    @PostMapping("/choice/save")
    public ClassifierChoice saveChoice(@RequestBody PersonChoiceSaveRequest personChoiceSaveRequest) {
        return personService.saveClassificationChoice(personChoiceSaveRequest);
    }

    @PatchMapping("/choice/save")
    public ClassifierChoice updateChoice(@RequestBody PersonChoiceSaveRequest personChoiceSaveRequest) {
        return personService.updateClassificationChoice(personChoiceSaveRequest);
    }

    @GetMapping("/choice")
    public ClassifierChoice getSelectedClassifier(@RequestParam long personId) {
        return classifierChoiceRepository.getById(personId);
    }
}
