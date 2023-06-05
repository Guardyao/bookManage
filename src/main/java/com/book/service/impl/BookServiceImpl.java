package com.book.service.impl;

import com.book.entity.Book;
import com.book.mapper.BookMapper;
import com.book.service.BookService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getBookRent() {
        try (SqlSession session = MybatisUtil.getSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.getBooks_Rent();
        }
    }

    @Override
    public Map<Book, Boolean> getMapValue(List<Book> book_rent, List<Book> allBook) {
        Map<Book, Boolean> map = new HashMap<>();
        Set<Book> book1 = new HashSet<>(book_rent);
        for (Book book : allBook) {
            if (book1.contains(book)) {
                map.put(book,true);
            } else {
                map.put(book,false);
            }
        }
        return map;
    }

    @Override
    public List<Book> getBookAll() {
        try (SqlSession session = MybatisUtil.getSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.getBooksAll();
        }
    }

    @Override
    public void deleteBook(int bid) {
        try (SqlSession session = MybatisUtil.getSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.deleteBook(bid);
        }
    }

    @Override
    public void addBook( String title, String author, double price) {
        try (SqlSession session = MybatisUtil.getSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.insertBook(title,author,price);
        }
    }
}
