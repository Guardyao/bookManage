package com.book.mapper;

import com.book.entity.Book;
import com.book.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
//    @Select("SELECT student.sid FROM student WHERE student.sid NOT IN (SELECT borrow.sid FROM borrow)")
//    List<Student> getStudents_notRent();
//

    @Select("select * from student")
    List<Student> getStudent();
}
