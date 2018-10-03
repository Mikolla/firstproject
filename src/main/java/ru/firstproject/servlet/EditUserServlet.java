package ru.firstproject.servlet;

import ru.firstproject.model.UsersDataSet;
import ru.firstproject.model.UsersDataSetDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet("/edituser")
public class EditUserServlet extends HttpServlet {

    public EditUserServlet()  throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userIdToEdit = Long.parseLong(request.getParameter("id"));
        UsersDataSet userToEdit = null;
        try {
            userToEdit = (new UsersDataSetDaoImpl()).getUserById(userIdToEdit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("user", userToEdit);
        request.getRequestDispatcher("edituser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Enumeration<String> stringEnum =  request.getParameterNames();
        long userIdToEdit = Long.parseLong(request.getParameter("id"));
        String newUserName = request.getParameter("name");
        String newUserLogin = request.getParameter("login");
        String newUserPassword = request.getParameter("password");
        UsersDataSet newUser = new UsersDataSet(userIdToEdit, newUserName, newUserLogin, newUserPassword);
        System.out.println(newUser.toString());
        new UsersDataSetDaoImpl().editUser(newUser);
        response.sendRedirect("/allusers");
    }

}
