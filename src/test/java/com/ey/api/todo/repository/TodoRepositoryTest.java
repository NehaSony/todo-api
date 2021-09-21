package com.ey.api.todo.repository;


import com.ey.api.todo.entity.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Neha Sony
 */


@DataJpaTest
class TodoRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    private Todo firstTodo;
    private Todo secondTodo;

    @BeforeEach
    public void setup() {
        this.firstTodo = new Todo("First Task Added");
        this.entityManager.persist(this.firstTodo);
        this.secondTodo = new Todo("Second Task Added");
        this.entityManager.persist(this.secondTodo);
    }

    @Test
    public void findAllTodos() {
        final List<Todo> todos = (List<Todo>) this.todoRepository.findAll();
        assertEquals(todos.size(),2);
    }

    @Test
    public void findOneTodo() {
        assertNotNull(this.todoRepository.findById(this.firstTodo.getId()));
    }


    @Test
    public void updateExistingTodo(){
        this.firstTodo.setTask("Updated First Task");
        this.todoRepository.save(this.firstTodo);
        assertNotNull(this.todoRepository.findById(this.firstTodo.getId()));
    }

    @Test
    public void deleteTodo() {
        this.todoRepository.delete(this.firstTodo);
        assertNotNull(this.todoRepository.findById(this.firstTodo.getId()));
    }

}