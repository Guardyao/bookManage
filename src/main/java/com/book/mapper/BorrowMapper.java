package com.book.mapper;

import com.book.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BorrowMapper {

    @Results({
            @Result(column = "bid", property = "book_id"),
            @Result(column = "id", property = "id"),
            @Result(column = "sid", property = "student_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "name", property = "student_name"),
            @Result(column = "time", property = "time")
    })
    @Select("select * from book,student,borrow where book.bid=borrow.bid and student.sid=borrow.sid")
    List<Borrow> getBorrow();

    @Delete("delete from borrow where bid = #{bid}")
    void returnBook(String bid);

    @Insert("insert into borrow(sid,bid,time) value(#{sid},#{bid},NOW())")
    void addBorrow(@Param("sid") int sid ,@Param("bid") int bid);
}
