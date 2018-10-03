package ru.firstproject.servlet;


import ru.firstproject.model.UsersDataSetDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deluser")
public class DelUserServlet extends HttpServlet {

    public DelUserServlet() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userIdToDel = Long.parseLong(request.getParameter("id"));
        try {
            new UsersDataSetDaoImpl().deleteUser(userIdToDel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/allusers");
    }

}
