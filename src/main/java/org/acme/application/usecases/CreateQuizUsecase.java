package org.acme.application.usecases;

import java.util.List;
import java.util.UUID;

import org.acme.domain.entities.Question;
import org.acme.domain.entities.Quiz;
import org.acme.infrastructure.repositories.QuizRepository;

public class CreateQuizUsecase {
    private final QuizRepository quizRepository;

    public CreateQuizUsecase(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(String title, List<Question> questions) {
        UUID id = UUID.randomUUID();
        Quiz newQuiz = new Quiz(id, title, questions);
        quizRepository.persist(newQuiz); // ? Persistir el nuevo cuestionario
        return newQuiz; // ? Devolver el cuestionario creado
    }
}
