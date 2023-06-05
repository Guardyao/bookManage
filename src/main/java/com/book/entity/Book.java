package com.book.entity;

import lombok.Data;

@Data
public class Book {
    int bid;
    String title;
    String author;
    double price;
}
