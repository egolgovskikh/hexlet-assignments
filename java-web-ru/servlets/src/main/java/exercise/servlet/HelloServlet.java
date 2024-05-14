package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static java.lang.String.format;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        var name = req.getParameter("name");

        res.setContentType("text/plain");
        if (name == null) {
            res.getWriter().write("Hello, Guest!");
        } else {
            res.getWriter().write(format("Hello, %s!", name));
        }
    }
    // END
}
