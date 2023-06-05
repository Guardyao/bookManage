package com.book.mapper;

import com.book.entity.Total;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface TotalMapper {

    @Select("SELECT "
            + "(SELECT COUNT(*) FROM book) AS book_count, "
            + "(SELECT COUNT(*) FROM student) AS student_count, "
            + "(SELECT COUNT(*) FROM borrow) AS borrow_count")
    @Results({
            @Result(property = "book_number", column = "book_count"),
            @Result(property = "student_number", column = "student_count"),
            @Result(property = "borrow_number", column = "borrow_count")
    })
    Total getTotal();
}
