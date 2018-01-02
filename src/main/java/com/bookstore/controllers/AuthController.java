/* * Open Source Code * */
package com.bookstore.controllers;

import com.bookstore.utilities.MessageUtility;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
@ManagedBean
@SessionScoped
public class AuthController {

    private String username;

    public AuthController() {
    }

    public void login() throws ServletException, IOException {
        // get current context
        FacesContext context = FacesContext.getCurrentInstance();
        // get current request and response
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        // get requested dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        // forward this request and response to the requested dispatcher
        dispatcher.forward(request, response);
        // end the context
        context.responseComplete();
    }
    
    public void preConstruct() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        if (request.getParameter("invalid").equals("true"))
        {
            MessageUtility.danger("The username and the password doesn't match our records");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
