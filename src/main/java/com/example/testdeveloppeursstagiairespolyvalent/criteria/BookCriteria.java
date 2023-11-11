package com.example.testdeveloppeursstagiairespolyvalent.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookCriteria {
    private String bookName;
    private String bookType;
    private Integer limit;

}
