package com.todolist.server;


import com.todolist.server.DTO.CurrentTaskDTO;
import com.todolist.server.entities.CurrentTask;
import com.todolist.server.mappers.CurrentTaskMapper;
import com.todolist.server.services.CurrentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class CurrentTaskController {

    @Autowired
    private CurrentTaskService currentTaskService;
    @Autowired
    private CurrentTaskMapper currentTaskMapper;

    @GetMapping("/current-tasks")
    public Collection<CurrentTaskDTO> getCurrentTasks() {
        return currentTaskMapper.toCurrentTaskDTOs(currentTaskService.findAll());
    }

    @PostMapping("/current-tasks")
    public CurrentTaskDTO saveCurrentTask(@RequestBody CurrentTaskDTO inputTask) {
        return currentTaskMapper.toCurrentTaskDTO(
            currentTaskService.save(currentTaskMapper.toCurrentTask(inputTask))
        );
    }

    @DeleteMapping("/current-tasks/{id}")
    public Map<String, Boolean> deleteCurrentTask(@PathVariable(value = "id") Long taskId)
        throws ResourceNotFoundException{
        currentTaskService.deleteById(taskId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/current-tasks/{id}")
    public ResponseEntity<CurrentTaskDTO> updateCurrentTasks(@PathVariable(value = "id") Long taskId,
                                                             @RequestBody CurrentTaskDTO taskDetails)
        throws ResourceNotFoundException {
        CurrentTaskDTO taskDTO = getCurrentTaskDTO(taskId);
        taskDTO.setDescription(taskDetails.getDescription());
        taskDTO.setCategory(taskDetails.getCategory());
        taskDTO.setTimestamp(taskDetails.getTimestamp());
        final CurrentTask updatedTask = currentTaskService.save(currentTaskMapper.toCurrentTask(taskDTO));
        return ResponseEntity.ok(currentTaskMapper.toCurrentTaskDTO(updatedTask));
    }

    private CurrentTaskDTO getCurrentTaskDTO(Long taskId) throws ResourceNotFoundException{
        return currentTaskMapper.toCurrentTaskDTO(currentTaskService.findById(taskId)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found for id: " + taskId)));
    }
}
