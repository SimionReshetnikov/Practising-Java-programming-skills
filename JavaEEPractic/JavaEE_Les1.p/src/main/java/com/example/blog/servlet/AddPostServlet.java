package com.example.blog.servlet;

import com.example.blog.storage.PostStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/posts/add")
public class AddPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form action='add' method='POST'>");
        out.println("Заголовок: <input type='text' name='title' required><br><br>");
        out.println("Текст: <textarea name='content' rows='5' cols='40' " +
                "placeholder='Введите ваш текст здесь...'></textarea><br><br>");
        out.println("<button type='submit'>Сохранить</button>");
        out.println("<p><a href=' "+ request.getContextPath() + "/posts'>К списку.</a></p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        if (title == null || title.isBlank() || content == null || content.isBlank()) {
            out.println("<h1>Некорректный заголовок или описание поста. Скорректируйте данные.</h1>");
            out.println("<p><a href='add'>Назад к форме</a></p>");
            return;
        }

        PostStorage.getInstance().createPost(title, content);
        response.sendRedirect(request.getContextPath() + "/posts");
    }
}
