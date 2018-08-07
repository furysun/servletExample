package controller;

import domain.Cat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static controller.CatAction.*;

public class Controller extends HttpServlet {
    private List<Cat> cats;

    private static final String LOGIN_VALUE = "admin";
    private static final String PASSWORD_VALUE = "admin";

    @Override
    public void init() throws ServletException {
        cats = new ArrayList<Cat>();
        cats.add(new Cat(0, "rose", 2));
        cats.add(new Cat(1, "ro", 4));
        cats.add(new Cat(2, "se", 6));
        cats.add(new Cat(3, "ose", 3));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        String action = req.getParameter("action");

        if (action.equals(GO_TO_LOGIN.name())) {
            resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
        } else if (action.equals(GO_TO_REGISTRATION.name())) {
            resp.sendRedirect(req.getContextPath() + "/jsp/registration.jsp");
        }

//        req.getSession().setAttribute("cats", cats);
//        resp.sendRedirect(req.getContextPath() + "/jsp/cats.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");

        String action = req.getParameter("action");

        if (action.equals(LOGIN.name())) {
            System.out.println("login");

            String login = req.getParameter("login");
            String password = req.getParameter("password");

            if(login.equals(LOGIN_VALUE)&&password.equals(PASSWORD_VALUE)){
                System.out.println("login successful");
                req.getSession().setAttribute("cats", cats);
                resp.sendRedirect(req.getContextPath() + "/jsp/cats.jsp");
            } else {
                req.getSession().setAttribute("error", true);
                resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
            }
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        if (action.equals(CREATE_CAT.name())) {
            String name = req.getParameter("name");
            String age = req.getParameter("age");

            Cat cat = new Cat(id, name, Integer.parseInt(age));
            cats.add(cat);
        } else if (action.equals(DELETE_CAT.name())) {
            removeCatById(id);
        } else if (action.equals(SHOW_EDIT_CAT.name())) {
            Cat cat = findCatById(id);
            req.getSession().setAttribute("catToEdit", cat);
        } else if (action.equals(EDIT_CAT.name())) {
            String name = req.getParameter("name");
            String age = req.getParameter("age");

            Cat cat = findCatById(id);
            cat.setAge(Integer.parseInt(age));
            cat.setName(name);

            req.getSession().setAttribute("catToEdit", null);
        }

        req.getSession().setAttribute("cats", cats);

        resp.sendRedirect(req.getContextPath() + "/jsp/cats.jsp");
    }

    private Cat findCatById(int id) {
        for (Cat cat : cats) {
            if (id == cat.getId()) {
                return cat;
            }
        }
        throw new CatNotFoundException();
    }

    public void removeCatById(int id) {
        for (int i = 0; i < cats.size(); i++) {
            if (id == cats.get(i).getId()) {
                cats.remove(i);
            }
        }
    }
}
