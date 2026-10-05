package com.example.storage;

import com.example.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTaskStorage {

    private TaskStorage storage;

    @BeforeEach
    void setUp() {
        storage = TaskStorage.getInstance();
        storage.clear();
    }

    @Test
    void createTask_withValidTitle_shouldAddTaskWithGeneratedId() {
        Task task = storage.createTask("Купить хлеб").orElse(null);

        assertNotNull(task);
        assertTrue(task.getId() > 0, "id должен быть положительным");
        assertEquals("Купить хлеб", task.getTitle());
        assertFalse(task.getDone(), "новая задача не должна быть выполненной");
    }

    @Test
    void createTask_shouldIncrementIdForEachTask() {
        Task first = storage.createTask("1").orElse(null);
        Task second = storage.createTask("2").orElse(null);

        assertTrue(second.getId() > first.getId(),
                "id второй задачи должен быть больше, чем id первой");
    }
}
