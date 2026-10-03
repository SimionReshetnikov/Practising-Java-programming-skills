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

        if (posts.isEmpty()) {
            out.println("<p>Постов пока нет</p>");
            return;
        }

        for (Post post : posts) {
            out.println("<p>" + post.toString() + "<!p>");
        }
    }
}
