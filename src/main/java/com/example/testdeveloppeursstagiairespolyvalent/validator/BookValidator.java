package com.example.testdeveloppeursstagiairespolyvalent.validator;

import com.example.testdeveloppeursstagiairespolyvalent.dto.BookDto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BookValidator {

    public static List<String> validate(BookDto bookDto) {
        List<String> errors = new ArrayList<>();

        if (bookDto == null) {
            errors.add("Enter Book Information");
            return errors;
        }

        if (StringUtils.isEmpty(bookDto.getBookName())) {
            errors.add("Book Name cannot be empty");
        }
        if (StringUtils.isEmpty(bookDto.getBookType())) {
            errors.add("Book Type cannot be empty");
        }
        if (StringUtils.isEmpty(bookDto.getBookDescription())) {
            errors.add("Book Description cannot be empty");
        }
        return errors;
    }
}
