package com.example.testdeveloppeursstagiairespolyvalent.service;

import com.example.testdeveloppeursstagiairespolyvalent.criteria.BookCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.dto.BookDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.Books;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;

import java.util.List;

public interface BooksService {

    Books findByType(String type);

    BookDto addBook(BookDto books);

    List<BookDto> listAddBooksWithCriteria(BookCriteria bookCriteria);

    MessageNotification updateBook(BookDto bookDto, Long id);

    MessageNotification deleteBook(BookDto bookDto, Long id);
}
