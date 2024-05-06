package org.acme.api.dtos;

import java.util.List;
import java.util.UUID;

import org.acme.domain.entities.Question;

public class QuizDTO {
    private UUID id;
    private String title;
    private List<Question> questions; //

    public QuizDTO(UUID id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public QuizDTO() {
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

}
