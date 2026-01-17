package com.example.Backend.dataConfig;

import com.example.Backend.model.Task;
import com.example.Backend.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public DataInitializer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) {

        // Prevent duplicate inserts on restart
        if (taskRepository.count() ==0) {


            List<Task> tasks = List.of(
                    new Task(
                            "Learn Spring Boot",
                            "Understand controllers, services, and repositories",
                            "Pending",
                            LocalDate.now().plusDays(5)
                    ),
                    new Task(
                            "Build Task Manager",
                            "Create CRUD APIs with MongoDB",
                            "In Progress",
                            LocalDate.now().plusDays(10)
                    ),
                    new Task(
                            "Frontend Integration",
                            "Connect React frontend with backend APIs",
                            "Done",
                            LocalDate.now().minusDays(2)
                    )
            );

            taskRepository.saveAll(tasks);

            System.out.println("✅ Sample task data inserted into MongoDB");
        }else{
            System.out.println(" ✔ Initial Data Already Present");
        }
    }
}
