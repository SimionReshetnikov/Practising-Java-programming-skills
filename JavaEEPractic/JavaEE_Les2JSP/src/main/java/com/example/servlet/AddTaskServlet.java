package com.example.servlet;

import com.example.storage.TaskStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasks/add")
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");

        if (title == null || title.isBlank()) {
            request.setAttribute("error", "Название задачи не может быть пустым");
            request.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request, response);
            return;
        }

        TaskStorage.getInstance().createTask(title);
        response.sendRedirect(request.getContextPath() + "/tasks");
    }
}
