package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {
    private UserDaoInter userDao= Context.instanceUserDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        String action=request.getParameter("action");
        if (action.equals("update")) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String birthdate=request.getParameter("birthdate");

        System.out.println("name=" + name);
        System.out.println("surname=" + surname);
        System.out.println("address="+address);
        System.out.println("phone="+phone);
        System.out.println("email="+email);
        System.out.println("birthdate="+birthdate);

        User user = userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);
        user.setBirthDate(Date.valueOf(birthdate));

        userDao.updateUser(user);
        }else if(action.equals("delete")){
        userDao.removeUser(id);
        }
        response.sendRedirect("users");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }
            Integer userId = Integer.parseInt(userIdStr);

            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("owner",true);
            request.setAttribute("user",u);
            request.getRequestDispatcher("userdetail.jsp").forward(request,response);
        }catch (Exception ex){
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }
    }
}

