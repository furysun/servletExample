package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("calc");
        resp.sendRedirect(req.getContextPath() + "/jsp/calc.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number1 = Integer.parseInt(req.getParameter("number1"));
        int number2 = Integer.parseInt(req.getParameter("number2"));
        String operator = req.getParameter("operator");
        int result = 0;

        if (operator.equals("+")) {
            result = number1 + number2;

        } else if (operator.equals("-")) {
            result = number1 - number2;
        } else if (operator.equals("*")) {
            result = number1 * number2;
        } else if (operator.equals("%")) {
            result = number1 % number2;
        }
        req.getSession().setAttribute("result", String.valueOf(result));

        resp.sendRedirect(req.getContextPath() + "/jsp/calc.jsp");
    }
}

