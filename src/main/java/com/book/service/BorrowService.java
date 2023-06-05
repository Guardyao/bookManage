package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> getBorowList();
    void returnBook(String id);
    void addBorrow(int sid, int bid);
    List<Book> getBooksNotRent();
}
