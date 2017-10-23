/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.repositories.impl;

import com.bookstore.models.Book;
import com.bookstore.repositories.IBookRepository;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author derickfelix
 */
public class BookRepositoryTest {
    
    public BookRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of create method, of class BookRepository.
     */
    @org.junit.Test
    public void testCreate() {
        System.out.println("create");
        Book book = new Book();
        book.setName("test");
        IBookRepository instance = new BookRepository();
        instance.create(book);
        
    }
}
