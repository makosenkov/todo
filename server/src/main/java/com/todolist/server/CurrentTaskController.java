package com.todolist.server;


import com.todolist.server.DTO.CurrentTaskDTO;
import com.todolist.server.mappers.CurrentTaskMapper;
import com.todolist.server.services.CurrentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class CurrentTaskController {

    @Autowired
    private CurrentTaskService currentTaskService;

    @GetMapping("/current-tasks")
    public Collection<CurrentTaskDTO> getCurrentTasks() {
        return CurrentTaskMapper.toCurrentTaskDTOs(currentTaskService.findAll());
    }

}
