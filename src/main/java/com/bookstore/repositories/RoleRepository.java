/* * Open Source Code. * */
package com.bookstore.repositories;

import com.bookstore.models.RoleModel;
import com.bookstore.models.UserModel;
import java.util.List;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public interface RoleRepository {

    /**
     * Add a new role to the storage.
     *
     * @param role the role bean to be added
     */
    public void create(RoleModel role);

    /**
     * Finds all the roles of a specific user.
     *
     * @param user the user desired
     * @return the list of roles of the user
     */
    public List<RoleModel> byUser(UserModel user);

    /**
     * Deletes the roles of a specified user.
     *
     * @param user the desired user
     * @param roles the list of roles to be deleted
     */
    public void delete(UserModel user, List<RoleModel> roles);
}
