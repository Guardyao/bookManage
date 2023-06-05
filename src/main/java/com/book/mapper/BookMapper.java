package com.book.mapper;

import com.book.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    @Select("SELECT * FROM book WHERE book.bid NOT IN (SELECT borrow.bid FROM borrow)")
    List<Book> getBooks_notRent();

    @Select("SELECT * FROM book WHERE book.bid  IN (SELECT borrow.bid FROM borrow)")
    List<Book> getBooks_Rent();

    @Select("select * from book")
    List<Book> getBooksAll();

    @Delete("delete from book where bid = #{bid}")
    void deleteBook(int bid);

    @Insert("insert into book(title,author,price) value(#{title},#{author},#{price})")
    void insertBook(@Param("title") String title, @Param("author")String author, @Param("price")double price);
}
