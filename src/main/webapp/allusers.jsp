<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<center>
    <h1>User list</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/admin/addUser">Add New User</a>
    </h2>

    <form action="${pageContext.servletContext.contextPath}/allusers" method="POST">

            <label for="uName">Username:</label>
            <input type="text" id="uName" name="name" placeholder="Input name"/>

            <label for="uLogin">Login:</label>
            <input type="text" id="uLogin" name="login" placeholder="Input login"/>

            <label for="uPassword">Password:</label>
            <input type="text" id="uPassword" name="password" placeholder="Input password"/>

            <input type="submit" align="center" value="Submit"/>


    </form>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${user.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td>id</td>
            <td>username</td>
            <td>userlogin</td>
            <td>userpass</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/addUser">Add New User</a>

                &nbsp;&nbsp;&nbsp;&nbsp;

            </td>
        </tr>

    </table>
</div>
</body>
</html>