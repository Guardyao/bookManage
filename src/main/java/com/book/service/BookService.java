package com.book.service;

import com.book.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> getBookAll();
    List<Book> getBookRent();
    Map<Book,Boolean> getMapValue(List<Book> book_rent,List<Book> allBook);
    void deleteBook(int bid);
    void addBook(String title,String author,double price);
}
