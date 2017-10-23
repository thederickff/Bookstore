/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bookstore.controllers;

import com.bookstore.models.Book;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * @name BookController
 * @author derickfelix
 * @date Oct 22, 2017
 */
@ManagedBean
@SessionScoped
public class BookController {

    private List<Book> books;
    private Book book;
    
    public BookController() {
        this.books = new ArrayList<>();
        this.book = new Book();
    }
    
    public void add() {
        Long serial = 0L;
        for (Book b : books) {
            serial = b.getId();
        }
        this.book.setId(serial+1);
        this.books.add(book);
        book = new Book();
    }
    
    public void edit(Book book) {
        this.books.remove(book.getId().intValue()-1);
        
        this.books.add(book);
    }
    
    public void remove(Book book) {
        this.books.remove(book.getId().intValue()-1);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
