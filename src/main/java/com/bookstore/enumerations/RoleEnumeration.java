package com.bookstore.enumerations;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public enum RoleEnumeration {

    HOME("Home page"),
    USERS("Users page"),
    SETTINGS("Settings page...");

    private String description;

    RoleEnumeration(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
