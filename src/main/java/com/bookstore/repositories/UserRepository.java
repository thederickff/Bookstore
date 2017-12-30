/** Open Source code **/
package com.bookstore.repositories;

import com.bookstore.models.User;
import java.util.List;

/**
 *
 * @author derickfelix
 * @Date 12/30/17
 */
public interface UserRepository {
    
    public List<User> all();
    
    public void add(User user);
    
    public User find(int id);
    
    public void delete(User user);
}
