/* * Open Source Code. * */
package com.bookstore.models;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public class RoleModel {
    
    private Integer ID;
    private String description;
    private boolean granted;
    private UserModel user;

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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
 
}
