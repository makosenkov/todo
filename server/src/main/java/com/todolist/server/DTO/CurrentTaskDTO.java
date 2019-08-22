package com.todolist.server.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentTaskDTO {
    private String description;
    private String category;
    private String timestamp;
}
