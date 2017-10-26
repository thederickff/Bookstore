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
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
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
        try {

            String separator = ";";
            long n = 0;
            FileReader fileReader = new FileReader("/home/derickfelix/.bookstore/books.data");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Collection<String> log = new HashSet<>();

            while (bufferedReader.ready()) {
                log.add(bufferedReader.readLine());
            }
            
            PrintWriter writer = new PrintWriter("/home/derickfelix/.bookstore/books.data");
            
            for (String s : log) {
                writer.print(s);
                writer.println();
                n++;
            }
            book.setId(n);
            writer.print(book.getId() + separator);
            writer.print(book.getName()+ separator);
            writer.print(book.getDescription()+ separator);
            writer.print(book.getPrice()+ separator);

        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("IOError: " + ex);
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
