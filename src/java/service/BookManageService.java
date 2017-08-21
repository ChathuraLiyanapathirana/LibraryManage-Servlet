/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.BookDto;
import java.util.ArrayList;

/**
 *
 * @author chathura buddhika
 */
public interface BookManageService {
    public boolean saveBook(BookDto bookDto);

    public ArrayList<BookDto> getAllBooks();

    public boolean UpdateBook(BookDto bookDto);

    public boolean deleteBook(String bookName);
}
