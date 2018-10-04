package ru.firstproject.servlet;


import ru.firstproject.model.User;
import ru.firstproject.dao.impl.user.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/allusers")
public class AllUsersServlet extends HttpServlet{
    UserDaoImpl usersDataSetDao = new UserDaoImpl();
	//private UserService service = UserServiceImpl.getInstance();

	public AllUsersServlet() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = null;
        try {
            users = usersDataSetDao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }


		request.setAttribute("users", users);

		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/allusers.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String newUserName = request.getParameter("name");
		String newUserLogin = request.getParameter("login");
		String newUserPassword = request.getParameter("password");
		User newUser = new User(-1, newUserName, newUserLogin, newUserPassword);
        System.out.println(newUser.toString());
        try {
            usersDataSetDao.saveUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/allusers");
	}

}
