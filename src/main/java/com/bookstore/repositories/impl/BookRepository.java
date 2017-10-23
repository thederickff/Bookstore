/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.repositories.impl;

import com.bookstore.models.Book;
import com.bookstore.repositories.IBookRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @name BookRepository
 * @author derickfelix
 * @date Oct 22, 2017
 */
public class BookRepository implements IBookRepository {

    @Override
    public List<Book> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book show(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Book book) {
        File file = new File("/home/derickfelix/.bookstore/books.data");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while (bufferedReader.ready()) {
                System.out.println("ok");
            }

            
        } catch (FileNotFoundException ex) {
            System.out.println("File error:" + ex);
        } catch (IOException ex) {
            System.out.println("IO error:" + ex);
        }
    }

    @Override
    public void update(Book book, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
