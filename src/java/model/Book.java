/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chathura buddhika
 */
public class Book {

    private String bookName;
    private String auther;
    private String isbn;

    public Book() {
    }

    public Book(String bookName, String auther, String isbn) {
        this.bookName = bookName;
        this.auther = auther;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return bookName + "~" + auther + "~" + isbn + "%";
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the auther
     */
    public String getAuther() {
        return auther;
    }

    /**
     * @param auther the auther to set
     */
    public void setAuther(String auther) {
        this.auther = auther;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
