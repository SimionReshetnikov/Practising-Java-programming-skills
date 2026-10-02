package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Привет из Servlet!</h1>");
        out.println("<p>Текущее время: " + LocalDateTime.now() + "</p>");

        out.println("<h2>Список HTTP заголовков</h2>");
        Enumeration<String> httpHeadline = request.getHeaderNames();
        while(httpHeadline.hasMoreElements()) {
            String nameHeader = httpHeadline.nextElement();
            String value = request.getHeader(nameHeader);
            out.println("<p><b>" + nameHeader + "</b> " + value + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String age = request.getParameter("age");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (username == null || username.isBlank()) {
            out.println("<h1>Ошибка ввода имени. Значение не может быть пустым.</h1>");
            return;
        }
        out.println("<h2>Привет, " + username + "!</h2>");
        out.println("<p>Тебе " + age + " лет.</p>");
        out.println("<p><a href='index.html'>Назад</a></p>");
    }
}