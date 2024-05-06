package org.acme.application.usecases;

import java.util.UUID;

import org.acme.domain.entities.Quiz;
import org.acme.infrastructure.repositories.QuizRepository;

public class GetQuizByIdUsecase {
    private final QuizRepository quizRepository;

    public GetQuizByIdUsecase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz getQuizById(UUID id) {
        return quizRepository.findById(id);
    }
}
