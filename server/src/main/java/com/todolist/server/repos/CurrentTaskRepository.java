package com.todolist.server.repos;


import com.todolist.server.entities.CurrentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CurrentTaskRepository extends JpaRepository<CurrentTask, Long> {
}
