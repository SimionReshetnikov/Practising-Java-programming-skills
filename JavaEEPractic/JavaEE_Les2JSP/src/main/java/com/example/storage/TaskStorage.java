package com.example.storage;

import com.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskStorage {

    private static final TaskStorage INSTANCE = new TaskStorage();
    private final List<Task> listTasks = new ArrayList<>();

    private TaskStorage() {}

    public static TaskStorage getInstance() {
        return INSTANCE;
    }

    public synchronized void createTask(int id, String title) {
        Task task = new Task(id, title);
        listTasks.add(task);
    }

    public synchronized List<Task> getAll() {
        return listTasks.stream()
                .map(item -> new Task(item.getId(), item.getTitle(), item.getCreatedAt()))
                .toList();
    }

    public synchronized Optional<Task> findById(int id) {
        return listTasks.stream().filter(t -> t.getId() == id).findFirst();
    }

    public synchronized boolean deleteById(int id) {
        Task task = listTasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);

        if (task == null) {
            return false;
        }

        listTasks.remove(task);
        return true;
    }
}
