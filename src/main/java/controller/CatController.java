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

public class CatController extends HttpServlet {
    private List<Cat> cats;

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
        req.getSession().setAttribute("cats", cats);

        resp.sendRedirect(req.getContextPath() + "/jsp/cats.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));

        if (action.equals(CREATE_CAT.name())) {
            String name = req.getParameter("name");
            String age = req.getParameter("age");

            Cat cat = new Cat(id, name, Integer.parseInt(age));
            cats.add(cat);
        } else if(action.equals(DELETE_CAT.name())){
            removeCatById(id);
        } else if(action.equals(SHOW_EDIT_CAT.name())){
            Cat cat = findCatById(id);
            req.getSession().setAttribute("catToEdit", cat);
        } else if(action.equals(EDIT_CAT.name())){
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
        for(Cat cat : cats){
            if(id == cat.getId()){
                return cat;
            }
        }
        throw new CatNotFoundException();
    }

    public void removeCatById(int id){
        for(int i = 0; i<cats.size();i++){
            if(id == cats.get(i).getId()){
                cats.remove(i);
            }
        }
    }
}
