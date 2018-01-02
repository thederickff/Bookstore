/* * Open Source Code. * */
package com.bookstore.services;

import com.bookstore.enumerations.RoleEnumeration;
import com.bookstore.models.RoleModel;
import com.bookstore.models.UserModel;
import com.bookstore.repositories.RoleRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public void create(UserModel user, List<RoleModel> roles) {
        this.repository.delete(user, roles);

        for (RoleModel role : roles) {
            role.setUser(user);
            this.repository.create(role);
        }
    }
    
    public List<RoleModel> byUser(UserModel user) {
        return repository.byUser(user);
    }
    
    public void delete(UserModel user, List<RoleModel> roles) {
        this.repository.delete(user, roles);
    }

    public List<RoleModel> loadRole(UserModel user) {
        List<RoleModel> roles = this.repository.byUser(user);
        if (user == null || roles.isEmpty()) {
            return clearRoles();
        }
        return roles;
    }

    private List<RoleModel> clearRoles() {
        List<RoleModel> roles = new ArrayList<>();

        for (RoleEnumeration p : RoleEnumeration.values()) {
            RoleModel role = new RoleModel();
            role.setID(p.ordinal());
            role.setDescription(p.getDescription());
            roles.add(role);
        }

        return roles;
    }
    
    public void checkInput(UserModel user) throws Exception {
        if (user == null)
            throw new Exception("Make sure you have selected a user.");
    }
}
