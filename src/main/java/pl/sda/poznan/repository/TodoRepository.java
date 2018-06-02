package pl.sda.poznan.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import pl.sda.poznan.model.TodoItem;

public class TodoRepository {

    private EntityManager entityManager;

    public TodoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<TodoItem> getAll() {
        return entityManager
                .createQuery("select td from TodoItem td", TodoItem.class)
                .getResultList();
    }

    public Optional<TodoItem> getById(Long id) {
        return Optional.empty();
    }

    public Optional<TodoItem> getByTitle(String title) {
        return Optional.empty();
    }

    public void save(TodoItem todoItem) {
        entityManager.getTransaction().begin();
        entityManager.persist(todoItem);
        entityManager.getTransaction().commit();
    }


}