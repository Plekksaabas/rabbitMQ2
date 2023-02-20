package com.jorgen.helmes.service;

import com.jorgen.helmes.domain.Classifier;
import com.jorgen.helmes.domain.ClassifierChoice;
import com.jorgen.helmes.domain.Person;
import com.jorgen.helmes.dto.PersonChoiceSaveRequest;
import com.jorgen.helmes.exception.NotSelectableException;
import com.jorgen.helmes.exception.RecordExistsException;
import com.jorgen.helmes.repository.ClassifierChoiceRepository;
import com.jorgen.helmes.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final ClassifierChoiceRepository classifierChoiceRepository;
    private final ClassifierService classifierService;

    public Person getPerson(long id) {
        return personRepository.getById(id);
    }

    public ClassifierChoice saveClassificationChoice(PersonChoiceSaveRequest request) {
        Classifier classifier = classifierService.getClassifier(request.getClassifierId());
        Person person = getPerson(request.getPersonId());

        checkIfNotPresent(request);
        checkIfValueCanBeChosen(classifier);

        return classifierChoiceRepository.save(ClassifierChoice.builder()
                .personId(person.getId())
                .classifier(classifier)
                .build());
    }

    public ClassifierChoice updateClassificationChoice(PersonChoiceSaveRequest request) {
        ClassifierChoice previousChoice = classifierChoiceRepository.getById(request.getPersonId());
        previousChoice.setClassifier(classifierService.getClassifier(request.getClassifierId()));

        checkIfValueCanBeChosen(previousChoice.getClassifier());

        return classifierChoiceRepository.save(previousChoice);
    }

    public ClassifierChoice getClassifierChoice(Long id)  {
        return classifierChoiceRepository.getById(id);
    }

    private void checkIfNotPresent(PersonChoiceSaveRequest request) {
        if (classifierChoiceRepository.findById(request.getPersonId()).isPresent()) {
            throw new RecordExistsException("ClassifierChoice", "Record already present");
        }
    }

    private void checkIfValueCanBeChosen(Classifier classifier) {
        if (!classifier.isSelectable()) {
            throw new NotSelectableException(classifier.getName());
        }
    }
}
