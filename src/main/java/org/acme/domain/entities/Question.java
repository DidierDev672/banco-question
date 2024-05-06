package org.acme.domain.entities;

import java.util.UUID;

import org.acme.domain.enums.QuestionType;

import java.util.List;

public class Question {
    private UUID id;
    private String text;
    private QuestionType type;
    private List<String> options; // Opciones para preguntas de opción múltiple
    private String correctAnswer; // Respuesta correcta para preguntas de opción múltiple o de otro tipo

    public Question(UUID id, String text, QuestionType type, List<String> options, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public QuestionType getType() {
        return type;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
