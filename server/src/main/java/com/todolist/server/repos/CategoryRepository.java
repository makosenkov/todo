package com.todolist.server.repos;

import com.todolist.server.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getCategoryByName(String name);
}
