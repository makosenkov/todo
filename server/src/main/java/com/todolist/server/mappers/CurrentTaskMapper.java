package com.todolist.server.mappers;

import com.todolist.server.DTO.CurrentTaskDTO;
import com.todolist.server.entities.Category;
import com.todolist.server.entities.CurrentTask;
import com.todolist.server.entities.User;
import com.todolist.server.repos.CategoryRepository;
import com.todolist.server.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentTaskMapper {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    public CurrentTaskDTO toCurrentTaskDTO(CurrentTask currentTask) {
        return new CurrentTaskDTO(
            currentTask.getDescription(),
            currentTask.getCategory().getName(),
            currentTask.getTimestamp().toString());
    }

    public List<CurrentTaskDTO> toCurrentTaskDTOs(List<CurrentTask> currentTasks) {
        List<CurrentTaskDTO> dtoList= new ArrayList<>();
        currentTasks.forEach(task -> dtoList.add(this.toCurrentTaskDTO(task)));
        return dtoList;
    }

    public CurrentTask toCurrentTask(CurrentTaskDTO currentTaskDTO) {
        Category category = categoryRepository.getCategoryByName(currentTaskDTO.getCategory().toLowerCase());
        User user = userRepository.getUserByLogin("admin");
        return new CurrentTask(
            currentTaskDTO.getDescription(),
            category,
            user);
    }
}
