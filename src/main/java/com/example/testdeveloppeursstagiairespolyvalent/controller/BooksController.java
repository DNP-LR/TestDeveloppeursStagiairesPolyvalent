package com.example.testdeveloppeursstagiairespolyvalent.controller;

import com.example.testdeveloppeursstagiairespolyvalent.controller.api.BooksApi;
import com.example.testdeveloppeursstagiairespolyvalent.criteria.BookCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.dto.BookDto;
import com.example.testdeveloppeursstagiairespolyvalent.service.BooksService;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksController implements BooksApi {

    private final BooksService booksService;

    @Override
    public List<BookDto> listAllBooksWithCriteria(String bookName, String bookType, Integer limit) {
        return booksService.listAddBooksWithCriteria(new BookCriteria(bookName, bookType, limit));
    }

    @Override
    public BookDto addBooks(BookDto bookDto) {
        return booksService.addBook(bookDto);
    }

    @Override
    public MessageNotification updateBookInfo(Long id, BookDto bookDto) {
        return booksService.updateBook(bookDto, id);
    }

    @Override
    public MessageNotification deleteBook(Long id, BookDto bookDto) {
        return booksService.deleteBook(bookDto, id);
    }
}
