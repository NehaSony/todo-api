package com.ey.api.todo.service;

import com.ey.api.todo.entity.Todo;
import com.ey.api.todo.exceptions.BadRequestException;
import com.ey.api.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author Neha.Sony
 */

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    /**
     *
     * Returns all the todos created
     *
     * @return
     */
    public List<Todo> fetchAllItems() {
        return (List<Todo>) todoRepository.findAll();
    }

    /**
     *
     * Gets a todoItem based on id
     *
     * @param id
     * @return
     * @throws BadRequestException
     */
    public Todo getTodoById(int id) throws BadRequestException {
        Todo todo = todoRepository.findById(id).get();
        if (todo==null||todo.getId()==null){
            throw new BadRequestException("Invalid Id");
        }
        return todo;
    }

    /**
     *
     * Save or updates a particular todoItem
     * if the payload does not contains id it saves
     * if the payload has an id, it updates
     *
     * @param todo
     * @return
     * @throws BadRequestException
     */
    public Todo saveOrUpdate(Todo todo) throws BadRequestException{
        try {
            todo.setTimeCreate(new Date(System.currentTimeMillis()));
            return todoRepository.save(todo);
        } catch (Exception e){
            throw new BadRequestException("Invalid Todo Item");
        }
    }

    /**
     *
     * Removes a todoItem
     *
     * @param id
     * @return
     * @throws BadRequestException
     */
    public Boolean delete(int id) throws BadRequestException{
        try {
            todoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new BadRequestException("Invalid Todo Item");
        }
    }
}
