package com.ey.api.todo.repository;

import com.ey.api.todo.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Neha.Sony
 */


@Repository
public interface TodoRepository extends CrudRepository <Todo,Integer>{
}
