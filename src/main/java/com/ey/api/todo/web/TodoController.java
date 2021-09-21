package com.ey.api.todo.web;

import com.ey.api.todo.entity.ErrorMessage;
import com.ey.api.todo.entity.Todo;
import com.ey.api.todo.exceptions.BadRequestException;
import com.ey.api.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Neha.Sony
 */

@RestController
@RequestMapping(value = "/v1/api/todo")
@Slf4j
@CrossOrigin
public class TodoController {

    @Autowired
    TodoService todoService;

    /**
     *
     * Returns list of all todos
     *
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<?> listAllTodos() {
        try {
            return new ResponseEntity<>(todoService.fetchAllItems(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * updates or inserts a todoItem
     *
     * @param Todo
     * @return
     */
    @PostMapping("/")
    private ResponseEntity<?> saveTodo(@RequestBody @Valid Todo Todo) {
        try {
            return new ResponseEntity<>(todoService.saveOrUpdate(Todo),HttpStatus.OK);
        }catch (BadRequestException e) {
            return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     *
     * Gets a todoItem by Id
     *
     * @param id
     * @return
     */
    @GetMapping("/todo/{id}")
    private ResponseEntity<?> getTodo(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(todoService.getTodoById(id),HttpStatus.OK);
        }catch (BadRequestException e) {
            return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * Deletes a todoItem by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/todo/{id}")
    private ResponseEntity<?> deleteTodo(@PathVariable("id") int id) {

        try {
            return new ResponseEntity<>(todoService.delete(id),HttpStatus.OK);
        }catch (BadRequestException e) {
            return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
