<%@ page import="com.company.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
<%
    User u=(User)request.getAttribute("user");
%>
<div>
    <form action="userdetail" method="POST">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <label for="name">name:</label>
        <input type="text" name="name" value="<%=u.getName()%>"/>
        <br/>
        <label for="surname">surname:</label>
        <input type="text" name="surname" value="<%=u.getSurname()%>"/>
        <br/>
        <label for="address">address:</label>
        <input type="text" name="address" value="<%=u.getAddress()%>"/>
        <br/>
        <label for="Phone">phone:</label>
        <input type="text" name="phone" value="<%=u.getPhone()%>"/>
        <br/>
        <label for="Email">email:</label>
        <input type="text" name="email" value="<%=u.getEmail()%>"/>
        <br/>
        <label for="birthdate">birthdate:</label>
        <input type="date" name="birthdate" value="<%=u.getBirthDate()%>"/>

        <input type="submit" name="save" value="Save"/>

    </form>
</div>
</body>
</html>

