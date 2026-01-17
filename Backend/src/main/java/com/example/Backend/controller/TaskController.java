
package com.example.Backend.controller;

import com.example.Backend.model.Task;
import com.example.Backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Create task
    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    // List tasks (exclude soft-deleted)
    @GetMapping
    public List<Task> list() {
        return service.listActive();
    }

    // Update task status
    @PatchMapping("/{id}/status")
    public Task updateStatus(@PathVariable String id, @RequestBody Map<String, String> body) {
        String status = body.get("status");
        return service.updateStatus(id, status).orElse(null);
    }

    // Soft delete task
    @PatchMapping("/{id}/delete")
    public void softDelete(@PathVariable String id) {
        service.softDelete(id);
    }
}
