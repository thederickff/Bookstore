/** Open Source code **/
package com.bookstore.services;

import com.bookstore.models.UserModel;
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
    
    public List<UserModel> all()
    {
        return repository.all();
    }
    
    public void add(UserModel user)
    {
        repository.add(user);
    }
    
    public UserModel find(int id)
    {
        return repository.find(id);
    }
    
    public void delete(UserModel user)
    {
        repository.delete(user);
    }
    
}
