package com.todolist.server.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CurrentTask> tasks;

    public Category(String name) {
        this.name = name;
        tasks = new HashSet<>();
    }
}
