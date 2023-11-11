package com.example.testdeveloppeursstagiairespolyvalent.mapper;

import com.example.testdeveloppeursstagiairespolyvalent.dto.BookDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.Books;
import com.example.testdeveloppeursstagiairespolyvalent.util.DateToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {


    public static BookDto fromEntity(Books bookModel) {
        if (bookModel == null) {
            return null;
        }

        BookDto bookDto = new BookDto();
        bookDto.setId(bookModel.getId());
        bookDto.setBookName(bookModel.getBookName());
        bookDto.setBookType(bookModel.getBookType());
        bookDto.setBookDescription(bookModel.getBookDescription());
        bookDto.setCreatedAtString(DateToStringUtil.getDateToString(bookModel.getCreateAt()));
        bookDto.setUpdatedAt(bookModel.getUpdatedAt());
        bookDto.setUpdatedAtString(DateToStringUtil.getDateToString(bookModel.getUpdatedAt()));

        return bookDto;
    }

    public static Books toEntity(BookDto bookDto) {

        if (bookDto == null) {
            return null;
        }
        Books booksModel = new Books();
        booksModel.setId(bookDto.getId());
        booksModel.setBookName(bookDto.getBookName());
        booksModel.setBookType(bookDto.getBookType());
        booksModel.setCreateAt(bookDto.getCreatedAt());
        booksModel.setBookDescription(bookDto.getBookDescription());
        return booksModel;
    }

    public static List<BookDto> fromEntities(List<Books> entities) {

        List<BookDto> dtos = new ArrayList<>();

        for (Books entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;

    }

}
