package com.example.blog.servlet;

import com.example.blog.model.Post;
import com.example.blog.storage.PostStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/posts/view")
public class ViewPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form action='view' method='POST'>");
        out.println("Id поста: <input type='text' name='id' required><br><br>");
        out.println("<button type='submit'>Найти</button>");
        out.println("<p><a href=' "+ request.getContextPath() + "/posts'>К списку.</a></p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        request.setCharacterEncoding("UTF-8");
        String idPost = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (idPost == null) {
            out.println("<p>Ошибка 400. Такой id отсутствует.</p>");
            out.println("<p><a href='view'>Назад к форме</a></p>");
            return;
        }

        try {
            int id = Integer.parseInt(idPost);
            Post post = PostStorage.getInstance().findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Пост с данным id не найден."));
            out.println("<h1>Заголовок: " + post.getHeadline() + "</h1>");
            out.println("<p>Дата создания поста: " + post.getDateTime() + "</p>");
            out.println("<p>" + post.getText() + "</p>");
            out.println("<p><a href=' "+ request.getContextPath() + "/posts'>К списку</a></p>");

        } catch (NumberFormatException ex) {
            out.println("<p>Ошибка 400. Некорректный формат id.</p>");
            out.println("<p><a href='view'>Назад к форме</a></p>");
        } catch (IllegalArgumentException ex) {
            out.println("<p>Ошибка 404. " + ex.getMessage() + "</p>");
            out.println("<p><a href='view'>Назад к форме</a></p>");
        }
    }
}
