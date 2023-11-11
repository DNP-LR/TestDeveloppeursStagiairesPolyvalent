package com.example.testdeveloppeursstagiairespolyvalent.controller.api;


import com.example.testdeveloppeursstagiairespolyvalent.dto.BookDto;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.testdeveloppeursstagiairespolyvalent.util.EndPointConstantUtil.BOOKS_END_POINT;

public interface BooksApi {

    @GetMapping(value = BOOKS_END_POINT)
    List<BookDto> listAllBooksWithCriteria(
            @RequestParam(value = "bookName", required = false) String bookName,
            @RequestParam(value = "bookType", required = false) String bookType,
            @RequestParam(value = "limit", required = false) Integer limit);

    @PostMapping(value = BOOKS_END_POINT)
    BookDto addBooks(@RequestBody BookDto bookDto);


    @PutMapping(value = BOOKS_END_POINT)
    MessageNotification updateBookInfo(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody BookDto bookDto);

    @DeleteMapping(value = BOOKS_END_POINT    )
    MessageNotification deleteBook(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody BookDto bookDto);

}
