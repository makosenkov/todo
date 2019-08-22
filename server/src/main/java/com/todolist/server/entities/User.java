package com.todolist.server.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter
    @Setter
    @Column(name = "login")
    private String login;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CurrentTask> tasks;

    @Getter
    @Setter
    @JsonManagedReference
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;
}
