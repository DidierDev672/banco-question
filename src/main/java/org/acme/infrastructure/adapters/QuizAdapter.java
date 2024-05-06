package org.acme.infrastructure.adapters;

import java.util.List;
import java.util.UUID;

import org.acme.domain.entities.Quiz;
import org.acme.infrastructure.repositories.QuizRepository;

public class QuizAdapter {
    private final QuizRepository quizRepository;

    public QuizAdapter(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // Obtiene todos los cuestionarios
    public List<Quiz> findAllQuizzes() {
        return quizRepository.listAll();
    }

    // Encuentra un cuestionario por ID
    public Quiz findQuizById(UUID id) {
        return quizRepository.findById(id);
    }

    // Guarda un nuevo cuestionario
    public void saveQuiz(Quiz quiz) {
        quizRepository.persist(quiz);
    }

    // Actualiza un cuestionario existente
    public void updateQuiz(Quiz quiz) {
        quizRepository.update(quiz);
    }

    // Elimina un cuestionario por su ID
    public void deleteQuizById(UUID id) {
        quizRepository.deleteById(id);
    }
}
