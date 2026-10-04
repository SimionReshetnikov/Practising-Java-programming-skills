package com.example.storage;

import com.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskStorage {

    private static final TaskStorage INSTANCE = new TaskStorage();
    private final List<Task> listTasks = new ArrayList<>();
    private static AtomicInteger count = new AtomicInteger(0);

    private TaskStorage() {}

    public static TaskStorage getInstance() {
        return INSTANCE;
    }

    public synchronized void createTask(String title) {
        Task task = new Task(count.incrementAndGet(), title);
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
        count.decrementAndGet();
        return true;
    }
}
