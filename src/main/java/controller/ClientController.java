package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do");
        resp.sendRedirect(req.getContextPath() + "/jsp/client.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("goToClientTwo")) {

            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");

            req.getSession().setAttribute("firstName", firstName);
            req.getSession().setAttribute("lastName", lastName);

            System.out.println("post");
            resp.sendRedirect(req.getContextPath() + "/jsp/clientTwo.jsp");
            return;

        } else if (action.equals("goToClientThree")) {
            String age = req.getParameter("age");

            req.getSession().setAttribute("age", age);

            resp.sendRedirect(req.getContextPath() + "/jsp/clientThree.jsp");
        } else if (action.equals("goToClientBack")) {
            resp.sendRedirect(req.getContextPath() + "/jsp/clientTwo.jsp");
        } else if (action.equals("goToClient")) {
            resp.sendRedirect(req.getContextPath() + "/jsp/client.jsp");
        }
    }
}
