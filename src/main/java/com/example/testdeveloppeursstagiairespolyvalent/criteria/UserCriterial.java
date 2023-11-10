package com.example.testdeveloppeursstagiairespolyvalent.criteria;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCriterial {

    private String userName;
    private String fullName;
    private String email;
    private Integer limit;

}
