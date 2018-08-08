package controller;

import domain.People;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeopleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do");
        List<People> people = new ArrayList<People>();

        people.add(new People("om",1));
        people.add(new People("tom",12));
        people.add(new People("tm",2));
        people.add(new People("m",54));
        req.getSession().setAttribute("people", people);

        resp.sendRedirect(req.getContextPath() + "/jsp/people.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("showName")){
            String name  = req.getParameter("name");

            req.getSession().setAttribute("name",name);
            resp.sendRedirect(req.getContextPath() + "/jsp/hello.jsp");
        }
    }
}
