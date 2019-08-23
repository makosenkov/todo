package com.todolist.server.repos;

import com.todolist.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String login);
}
