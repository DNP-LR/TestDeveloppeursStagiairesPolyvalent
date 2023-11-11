package com.example.testdeveloppeursstagiairespolyvalent.service.impl;

import com.example.testdeveloppeursstagiairespolyvalent.criteria.BookCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.dto.BookDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.Books;
import com.example.testdeveloppeursstagiairespolyvalent.exception.ErrorCodes;
import com.example.testdeveloppeursstagiairespolyvalent.exception.InvalidEntityException;
import com.example.testdeveloppeursstagiairespolyvalent.mapper.BookMapper;
import com.example.testdeveloppeursstagiairespolyvalent.repository.BookRepo;
import com.example.testdeveloppeursstagiairespolyvalent.service.BooksService;
import com.example.testdeveloppeursstagiairespolyvalent.specification.BookSpecification;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;
import com.example.testdeveloppeursstagiairespolyvalent.util.MethodUtil;
import com.example.testdeveloppeursstagiairespolyvalent.validator.BookValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.testdeveloppeursstagiairespolyvalent.util.TranslationConstantUtil.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BooksService {

    private final BookRepo bookRepo;


    @Override
    public Books findByType(String type) {
        if (type == null) {
            throw new NullPointerException(ID_CAN_NOT_BE_NULL);
        }
        Optional<Books> books = bookRepo.findByBookType(type);
        return books.orElse(null);
    }

    @Override
    public BookDto addBook(BookDto books) {
        List<String> errors = BookValidator.validate(books);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException(INVALID_REQUEST, ErrorCodes.BOOK_NOT_VALID, errors);
        }
        Books bookModel = BookMapper.toEntity(books);
        List<String> errorExist = checkIfBookInfoExist(bookModel);
        if (!errorExist.isEmpty()) {
            throw new InvalidEntityException(INVALID_REQUEST, ErrorCodes.BOOK_NOT_VALID, errorExist);
        }
        System.out.println(bookModel);
        bookModel.setBookName(books.getBookName());
        bookModel.setBookType(books.getBookType());
        bookModel.setBookDescription(books.getBookDescription());
        Books saveBook = bookRepo.save(bookModel);
        return BookMapper.fromEntity(saveBook);
    }

    @Override
    public List<BookDto> listAddBooksWithCriteria(BookCriteria bookCriteria) {
        Pageable pageable = MethodUtil.findAllByCriteria(bookCriteria.getLimit());
        return BookMapper.fromEntities(bookRepo.findAll(BookSpecification.getSpecification(bookCriteria), pageable).getContent());
    }

    @Override
    public MessageNotification deleteBook(BookDto bookDto, Long id) {
        Optional<Books> existingBook = bookRepo.findById(id);
        if (existingBook.isPresent()) {
            bookRepo.delete(existingBook.get());
            return new MessageNotification("1", "Book deleted successfully");
        } else {
            return new MessageNotification("0", "Book not found");
        }
    }

    @Override
    public MessageNotification updateBook(BookDto bookDto, Long id) {
        return null;
    }


    public List<String> checkIfBookInfoExist(Books books) {
        List<String> errors = new ArrayList<>();
        if (findByType(books.getBookType()) != null) {
            errors.add(A_BOOK_ALREADY_EXIST_WITH_THIS_NAME);
        }
        return errors;
    }
}
