package org.acme.application.services;

import java.util.List;
import java.util.UUID;

import org.acme.application.usecases.CreateQuizUsecase;
import org.acme.application.usecases.GetQuizByIdUsecase;
import org.acme.domain.entities.Question;
import org.acme.domain.entities.Quiz;

public class QuizService {
    private final CreateQuizUsecase createQuizUsecase;
    private final GetQuizByIdUsecase getQuizByIdUsecase;

    public QuizService(CreateQuizUsecase createQuizUsecase, GetQuizByIdUsecase getQuizByIdUsecase) {
        this.createQuizUsecase = createQuizUsecase;
        this.getQuizByIdUsecase = getQuizByIdUsecase;
    }

    public Quiz createQuiz(String title, List<Question> questions) {
        return createQuizUsecase.createQuiz(title, questions); // ? Usar el caso de uso para crear un cuestionario
    }

    public Quiz getQuizById(UUID id) {
        return getQuizByIdUsecase.getQuizById(id);
    }
}
