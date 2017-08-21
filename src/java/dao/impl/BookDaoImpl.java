/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import connection.Connection;
import connection.ConnectionFactory;
import dao.BookDao;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import model.Book;

/**
 *
 * @author chathura buddhika
 */
public class BookDaoImpl implements BookDao{

    public int saveBook(Book book) {
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String booksData = p.get("BooksDetail", "");
        booksData += book.toString();
        p.put("BooksDetail", booksData);
        return 1;
    }

    public ArrayList<Book> getAllBooks() {
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String booksData = p.get("BooksDetail", "");
        ArrayList<Book> list = new ArrayList<Book>();
        if (!booksData.equals("")) {
            String[] split = booksData.split("%");
            for (String split1 : split) {
                String[] split2 = split1.split("~");
                Book m = new Book(split2[0], split2[1], split2[2]);
                list.add(m);
            }
        }
        return list;
    }

    public int updateBook(Book book) {
        int isUpdate = 0;
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String booksData = p.get("BooksDetail", "");
        String[] split = booksData.split("%");
        String newList = "";
        for (String split1 : split) {
            String[] split2 = split1.split("~");
            if (book.getBookName().equals(split2[0])) {
            } else {
                newList += split1 + "%";
            }
        }
        newList += book.toString();
        isUpdate = 1;
        p.put("BooksDetail", newList);
        return isUpdate;
    }

    public int deleteBook(String name) {
        int isDelete = 0;
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String booksData = p.get("BooksDetail", "");
        String newList = "";
        String[] split = booksData.split("%");
        for (String split1 : split) {
            String[] split2 = split1.split("~");
            if (name.equals(split2[0])) {
                isDelete = 1;
            } else {
                newList += split1 + "%";
            }
        }
        p.put("BooksDetail", newList);
        return isDelete;
    }

    
}
