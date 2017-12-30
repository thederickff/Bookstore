/** Open Source code **/
package com.bookstore.services;

import com.bookstore.models.User;
import com.bookstore.repositories.UserRepository;
import java.util.List;

/**
 *
 * @author derickfelix
 * @date 12/30/17
 */
public class UserService {
    
    private final UserRepository repository;
    
    public UserService(UserRepository repository)
    {
        this.repository = repository;
    }
    
    public List<User> all()
    {
        return repository.all();
    }
    
    public void add(User user)
    {
        repository.add(user);
    }
    
    public User find(int id)
    {
        return repository.find(id);
    }
    
    public void delete(User user)
    {
        repository.delete(user);
    }
    
}
