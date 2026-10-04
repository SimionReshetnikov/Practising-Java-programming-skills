package com.example.servlet;

import com.example.model.Task;
import com.example.storage.TaskStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class ListTasksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Task> listTasks = TaskStorage.getInstance().getAll();

        request.setAttribute("tasks", listTasks);
        request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
    }
}
