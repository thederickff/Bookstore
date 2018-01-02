/* * Open Source Code. * */
package com.bookstore.models;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public class Role {
    
    private Integer ID;
    private String description;
    private boolean granted;
    private User user;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGranted() {
        return granted;
    }

    public void setGranted(boolean granted) {
        this.granted = granted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
 
}
