package ru.firstproject.servlet;

import ru.firstproject.model.User;
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
import java.util.Enumeration;

@WebServlet("/edituser")
public class EditUserServlet extends HttpServlet {

   // UserDaoImpl usersDataSetDao = new UserDaoImpl(connection);
   private final UserService userService = new UserServiceImpl();

    public EditUserServlet()  throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userIdToEdit = Long.parseLong(request.getParameter("id"));
        User userToEdit = null;
        try {
     //       userToEdit = usersDataSetDao.getUserById(userIdToEdit);
            userToEdit =  userService.getUserById(userIdToEdit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("user", userToEdit);
        request.getRequestDispatcher("edituser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


      /*  Enumeration<String> stringEnum =  request.getParameterNames();
        long userIdToEdit = Long.parseLong(request.getParameter("id"));
        String newUserName = request.getParameter("name");
        String newUserLogin = request.getParameter("login");
        String newUserPassword = request.getParameter("password");
        User newUser = new User(userIdToEdit, newUserName, newUserLogin, newUserPassword);
        System.out.println(newUser.toString());
        usersDataSetDao.editUser(newUser);
        response.sendRedirect("/allusers"); */
    }

}
