package org.acme.api.resources;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.acme.api.dtos.QuizDTO;
import org.acme.domain.entities.Quiz;
import org.acme.infrastructure.adapters.QuizAdapter;

public class QuizResource {
    private final QuizAdapter quizAdapter;

    public QuizResource(QuizAdapter quizAdapter) {
        this.quizAdapter = quizAdapter;
    }

    public List<QuizDTO> findAllQuizzes() {
        List<Quiz> quizzes = quizAdapter.findAllQuizzes();
        return quizzes.stream()
                .map(quiz -> new QuizDTO(quiz.getId(), quiz.getTitle(), quiz.getQuestions()))
                .collect(Collectors.toList());
    }

    public Quiz findQuizById(UUID id) {
        return quizAdapter.findQuizById(id);
    }

    public void createQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz(UUID.randomUUID(), quizDTO.getTitle(), quizDTO.getQuestions());
        quizAdapter.saveQuiz(quiz);
    }

    public void updateQuiz(UUID id, QuizDTO quizDTO) {
        Quiz quizOptional = quizAdapter.findQuizById(id);
        if (quizOptional.getId() != null) {
            Quiz quiz = quizOptional;
            quiz.setId(quizDTO.getId());
            quiz.setTitle(quizDTO.getTitle());
            quiz.setQuestions(quizDTO.getQuestions());
            quizAdapter.updateQuiz(quiz);
        }
    }

    public void deleteQuiz(UUID id) {
        quizAdapter.deleteQuizById(id);
    }
}
