package com.todolist.server.services;

import com.todolist.server.entities.CurrentTask;
import com.todolist.server.repos.CurrentTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrentTaskService {
    @Autowired
    private CurrentTaskRepository currentTaskRepository;

    public List<CurrentTask> findAll() {
        return currentTaskRepository.findAll();
    }

    public Optional<CurrentTask> findById(Long id) {
        return currentTaskRepository.findById(id);
    }

    public CurrentTask save(CurrentTask task) {
        return currentTaskRepository.save(task);
    }

    public void deleteById(Long id) {
        currentTaskRepository.deleteById(id);
    }
}
