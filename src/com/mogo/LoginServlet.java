package com.mogo;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.*;
import java.io.PrintWriter;

/**
 * Created by Vitalii Moholivskyi on 1/12/16.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet{

    private final String LOGIN = "green";
    private final String PASSWORD = "cactus";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException{
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("<!DOCTYPE html><html><head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <title>Login Page</title> <link rel=\"stylesheet\" href=\"http://yui.yahooapis.com/pure/0.6.0/pure-min.css\"></head><body> <div style=\"width: 700px;height: 100px;position: absolute;top:0;bottom: 0;left: 0;right: 0;margin: auto;\"> <form class=\"pure-form\" method=\"POST\" action=\"\"> <fieldset> <label for=\"login\">Login</label> <input name=\"login\" type=\"text\" placeholder=\"Login\" required> <label for=\"password\">Password</label> <input name=\"password\" type=\"password\" placeholder=\"Password\" required> <button type=\"submit\" class=\"pure-button pure-button-primary\">Let me come in :)</button> </fieldset> <p> Default login is \"<b>green</b>\" and default password is \"<b>cactus</b>\". </p></form> </div></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(isValid(request.getParameter("login"),
                   request.getParameter("password")))
             out.print("Welcome! You're successfully logged in.");
        else out.print("Error. Wrong login or password. Go back and try again.");
    }

    private boolean isValid(String login, String password){
        if(login.equals(LOGIN) && password.equals(PASSWORD)) return true;
        return false;
    }
}
