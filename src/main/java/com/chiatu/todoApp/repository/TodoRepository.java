package com.chiatu.todoApp.repository;

import com.chiatu.todoApp.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
