package org.acme.domain.entities;

import java.util.UUID;
import java.util.List;

public class Quiz {
    private UUID id;
    private String title;
    private List<Question> questions; // Lista de preguntas en el cuestionario

    public Quiz(UUID id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    // Setter para 'id'
    public void setId(UUID id) {
        this.id = id;
    }

    // Setter para 'title'
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter para 'questions'
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
