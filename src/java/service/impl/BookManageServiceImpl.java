/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.BookDao;
import dao.DaoFactory;
import dto.BookDto;
import java.util.ArrayList;
import model.Book;
import service.BookManageService;

/**
 *
 * @author chathura buddhika
 */
public class BookManageServiceImpl implements BookManageService {

    public boolean saveBook(BookDto bookDto) {
        BookDao bookDao = DaoFactory.getBookDao();
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setAuther(bookDto.getAuther());
        book.setIsbn(bookDto.getIsbn());
        int saveBook = bookDao.saveBook(book);
        return saveBook > 0;
    }

    public ArrayList<BookDto> getAllBooks() {
        ArrayList<Book> allBooks = DaoFactory.getBookDao().getAllBooks();
        ArrayList<BookDto> list = new ArrayList<BookDto>();
        for (Book book : allBooks) {
            BookDto dto = new BookDto(book.getBookName(), book.getAuther(), book.getIsbn());
            list.add(dto);
        }
        return list;
    }

    public boolean UpdateBook(BookDto bookDto) {
        BookDao bookDao = DaoFactory.getBookDao();
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setAuther(bookDto.getAuther());
        book.setIsbn(bookDto.getIsbn());
        int saveMember = bookDao.updateBook(book);
        return saveMember > 0;
    }

    public boolean deleteBook(String bookName) {
        int deleteBook = DaoFactory.getBookDao().deleteBook(bookName);
        return deleteBook > 0;
    }

}
