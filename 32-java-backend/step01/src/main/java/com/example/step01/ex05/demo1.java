package com.example.step01.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiple")
public class demo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    public void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String danParam = request.getParameter("dan");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();

        sb.append("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>Multiplication Table</title>
                </head>
                <body>
                    <h1>Multiplication Table</h1>
                """);

        if (danParam != null && !danParam.isEmpty()) {
            try {
                int dan = Integer.parseInt(danParam);
                if (dan >= 2 && dan <= 9) {
                    sb.append("<pre>");
                    for (int i = 1; i <= 9; i++) {
                        sb.append(String.format("%d * %d = %d\n", dan, i, dan * i));
                    }
                    sb.append("</pre>");
                } else {
                    sb.append("<p style='color:red;'>").append(dan).append(" is an invalid value.</p>");
                }
            } catch (NumberFormatException e) {
                sb.append("<p style='color:red;'>Invalid input.</p>");
            }
        }

        sb.append("""
                    <form action="multiple" method="post">
                        <p>
                            Multiplication table for
                            <input type="number" name="dan" min="2" max="9" required>
                            <input type="submit" value="Print">
                        </p>
                    </form>
                </body>
                </html>
                """);

        out.print(sb.toString());
        out.close();
    }
}