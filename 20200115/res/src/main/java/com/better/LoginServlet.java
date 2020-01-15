package com.better;

import com.better.dao.UserDao;
import com.better.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();
        User user = userDao.findUserByUsernameAndPassword(username,password);
        if (user == null) {
            System.out.println("用户不存在");
            return;
        }

        HttpSession session = req.getSession();
        System.out.println(session.getId());

        session.setAttribute("user",user);

        resp.sendRedirect("/success");
    }
}
