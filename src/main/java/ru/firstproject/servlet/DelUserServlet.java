package ru.firstproject.servlet;


import ru.firstproject.dao.impl.user.UserDaoImpl;
import ru.firstproject.service.abstraction.user.UserService;
import ru.firstproject.service.impl.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/deluser")
public class DelUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public DelUserServlet()  {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userIdToDel = Long.parseLong(request.getParameter("id"));
        try {
            userService.deleteUser(userIdToDel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/allusers");
    }

}
