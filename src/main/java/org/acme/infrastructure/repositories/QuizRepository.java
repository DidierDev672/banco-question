package org.acme.infrastructure.repositories;

import java.util.Optional;
import java.util.UUID;

import org.acme.domain.entities.Quiz;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuizRepository implements PanacheRepositoryBase<Quiz, UUID> {
    /**
     * Persiste un nuevo cuestionario
     */

    public void persist(Quiz quiz) {
        persistAndFlush(quiz);
    }

    /**
     * Encuentra un cuestionario por su ID.
     */
    public Quiz findById(UUID id) {
        return find("id", id).firstResult();
    }

    /**
     * Actualiza un cuestionario existente.
     */
    public void update(Quiz quiz) {
        persistAndFlush(quiz); // Merge con persistAndFlush para asegurarse de que los cambios se guarden
    }

    /**
     * Elimina un cuestionario por su ID.
     */
    public void delete(UUID id) {
        delete("id", id); // Elimina el cuestionario por su ID
    }
}
