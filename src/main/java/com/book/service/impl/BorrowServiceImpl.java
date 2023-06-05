package com.book.service.impl;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.User;
import com.book.mapper.BookMapper;
import com.book.mapper.BorrowMapper;
import com.book.mapper.UserMapper;
import com.book.service.BorrowService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    @Override
    public List<Borrow> getBorowList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
            return mapper.getBorrow();
        }
    }
    @Override
    public  void returnBook(String id){
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
            mapper.returnBook(id);
        }
    }

    @Override
    public void addBorrow(int sid, int bid) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
            mapper.addBorrow(sid,bid);
        }
    }

    @Override
    public List<Book> getBooksNotRent() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            return mapper.getBooks_notRent();
        }
    }
}
