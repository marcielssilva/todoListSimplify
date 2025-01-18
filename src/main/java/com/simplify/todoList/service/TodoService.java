package com.simplify.todoList.service;

import com.simplify.todoList.entity.Todo;
import com.simplify.todoList.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create (Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    List<Todo> list () {
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    List<Todo> update (Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    List<Todo> delete (Long id) {
        todoRepository.deleteById(id);
                return list();
    }
}
