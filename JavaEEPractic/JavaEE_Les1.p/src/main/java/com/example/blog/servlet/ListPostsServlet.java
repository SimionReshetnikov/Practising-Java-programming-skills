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
import java.util.List;

@WebServlet("/posts")
public class ListPostsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Все посты.</h1>");
        List<Post> posts = PostStorage.getInstance().getAll();

        out.println("<p><a href='" + request.getContextPath() + "/posts/add'>Добавить пост</a></p>");
        out.println("<p><a href='" + request.getContextPath() + "/posts/view'>Найти пост по id</a></p>");

        if (posts.isEmpty()) {
            out.println("<p>Постов пока нет</p>");
        }

        for (Post post : posts) {
            out.println("<p>" + post.toString() + "</p>");
        }
    }
}
