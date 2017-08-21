/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Book;

/**
 *
 * @author chathura buddhika
 */
public interface BookDao {
    public int saveBook(Book book);

    public ArrayList<Book> getAllBooks();

    public int updateBook(Book book);

    public int deleteBook(String name);
}
