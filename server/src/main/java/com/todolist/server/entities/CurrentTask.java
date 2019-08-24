package com.todolist.server.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@NoArgsConstructor
public class CurrentTask implements Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Getter
    @Setter
    @Column(name = "timestamp")
    private LocalDate timestamp;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public CurrentTask(String description, Category category, User user, LocalDate timestamp) {
        this.description = description;
        this.timestamp = timestamp;
        this.category = category;
        this.userId = user;
    }
}
