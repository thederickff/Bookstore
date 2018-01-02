/* * Open Source Code * */
package com.bookstore.utilities;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public class MessageUtility {
    
    private static FacesContext context;
    
    public static void success(String message) {
        create(message, FacesMessage.SEVERITY_INFO);
    }
    
    public static void warning(String message) {
        create(message, FacesMessage.SEVERITY_WARN);
    }
    
    public static void danger(String message) {
        create(message, FacesMessage.SEVERITY_ERROR);
    }
    
    private static void create(String message, Severity severity) {
         context = FacesContext.getCurrentInstance();
         context.getExternalContext().getFlash().setKeepMessages(true);
         context.addMessage(null, new FacesMessage(severity, message, message));
    }
}
