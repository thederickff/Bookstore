/* * Open Source Code. * */
package com.bookstore.security;

import com.bookstore.enumerations.RoleEnumeration;
import com.bookstore.models.RoleModel;
import com.bookstore.models.UserModel;
import com.bookstore.repositories.impl.RoleRepositoryImpl;
import com.bookstore.repositories.impl.UserRepositoryImpl;
import com.bookstore.services.RoleService;
import com.bookstore.services.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public class DefaultUser {

    private UserService userService;
    private RoleService roleService;
    
    public DefaultUser() {
        this.userService = new UserService(new UserRepositoryImpl());
        this.roleService = new RoleService(new RoleRepositoryImpl());
    }
    
    public void addDefaultUser() {
        this.userService.add(create());
        addRoles();
    }
    
    public void removeDefaultUser() {
        this.userService.delete(create());
        removeRoles();
    }
    
    
    private void addRoles() {
        List<RoleModel> roles = new ArrayList<>();
        UserModel user = create();
        
        for (RoleEnumeration roleEnum : RoleEnumeration.values()) {
            RoleModel role = new RoleModel();
            role.setID(roleEnum.ordinal());
            role.setDescription(roleEnum.getDescription());
            role.setGranted(true);
            role.setUser(user);
            roles.add(role);
        }
        roleService.create(user, roles);
    }
    
    private void removeRoles() {
        UserModel user = create();
        List<RoleModel> roles = roleService.byUser(user);
        roleService.delete(user, roles);
    }
    
    private UserModel create() {
        UserModel user = new UserModel();
        user.setId(1);
        user.setName("root");
        user.setEmail("email@example.com");
        user.setPassword("secret");
        
        return user;
    }
}
