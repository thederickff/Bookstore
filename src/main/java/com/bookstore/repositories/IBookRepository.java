/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.repositories;

import com.bookstore.models.Book;
import java.util.List;

/**
 *
 * @author derickfelix
 */
public interface IBookRepository {
    
    public List<Book> all();
    
    public Book show(long id);
    
    public void create(Book book);
    
    public void update(Book book, long id);
    
    public void delete(long id);
    
}
