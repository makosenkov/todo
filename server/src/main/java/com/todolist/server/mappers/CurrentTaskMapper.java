package com.todolist.server.mappers;

import com.todolist.server.DTO.CurrentTaskDTO;
import com.todolist.server.entities.Category;
import com.todolist.server.entities.CurrentTask;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentTaskMapper {

    public static CurrentTaskDTO toCurrentTaskDTO(CurrentTask currentTask) {
        return new CurrentTaskDTO(
            currentTask.getDescription(),
            currentTask.getCategory().getName(),
            currentTask.getTimestamp().toString());
    }

    public static List<CurrentTaskDTO> toCurrentTaskDTOs(List<CurrentTask> currentTasks) {
        List<CurrentTaskDTO> dtoList= new ArrayList<>();
        currentTasks.forEach(task -> dtoList.add(CurrentTaskMapper.toCurrentTaskDTO(task)));
        return dtoList;
    }

    public static CurrentTask toCurrentTask(CurrentTaskDTO currentTaskDTO) {
        return new CurrentTask(
            currentTaskDTO.getDescription(),
            new Category(currentTaskDTO.getCategory()));
    }
}
