
package com.example.Backend.repository;

import com.example.Backend.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByIsDeletedFalseOrderByDueDateAsc();
}
