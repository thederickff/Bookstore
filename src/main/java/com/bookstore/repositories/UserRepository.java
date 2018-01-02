/** Open Source code * */
package com.bookstore.repositories;

import com.bookstore.models.User;
import java.util.List;

/**
 *
 * @author derickfelix
 * @Date 12/30/17
 */
public interface UserRepository {

    /**
     * Gets all the users saved in the storage
     *
     * @return a List of users
     */
    public List<User> all();

    /**
     * Add a new user to the storage
     *
     * @param user the user bean to be added
     */
    public void add(User user);

    /**
     * Finds a user by specifying its id
     *
     * @param id the id of the user
     * @return the user that matches with the id specified
     */
    public User find(int id);

    /**
     * Delete a user
     *
     * @param user the user to be deleted
     */
    public void delete(User user);

}
