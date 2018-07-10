package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init ");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("mr");

        String login = req.getParameter("login");
        String fam = req.getParameter("Fam");

        System.out.println(login);
        System.out.println(req.getParameter("password"));

        HttpSession session = req.getSession();
        session.setAttribute("name", login);
        session.setAttribute("fam", fam);

        resp.sendRedirect(req.getContextPath() + "/jsp/hello.jsp");
    }
}
