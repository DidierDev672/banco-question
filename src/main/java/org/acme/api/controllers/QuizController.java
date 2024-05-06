package org.acme.api.controllers;

import java.util.List;
import java.util.UUID;

import org.acme.application.services.QuizService;
import org.acme.domain.entities.Question;
import org.acme.domain.entities.Quiz;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/quizzes")
public class QuizController {
    private final QuizService quizService;

    // ? Inyección del servicio en el constructor del controlador
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // ? Endpoint para crear un nuevo quiz
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createQuiz(CreateQuizRequest request) {
        Quiz quiz = quizService.createQuiz(request.getTitle(), request.getQuestions()); // ? Crear el quiz
        return Response.status(Response.Status.CREATED).entity(quiz).build(); // ? Devolver respuesta 201 CREATED
    }

    // ? Endpoint para obtener un quiz por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuizById(@PathParam("id") UUID id) {
        Quiz quiz = quizService.getQuizById(id); // ? Obtener el quiz por ID
        if (quiz == null) { // ? Si no se encuentra, devolver 404
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(quiz).build(); // ? Devolver respuesta 200 OK
    }

    // ? Clase para la estructura del request del POST
    public static class CreateQuizRequest {
        private String title;
        private List<Question> questions;

        // ! Getters y setters para el request
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Question> getQuestions() {
            return questions;
        }

        public void setQuestions(List<Question> questions) {
            this.questions = questions;
        }
    }
}
