package com.example.testdeveloppeursstagiairespolyvalent.util;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class MethodUtil {

    public static String format(Integer value, int numberCharMax) {
        String val = value.toString();
        StringBuilder fixe = new StringBuilder();
        if (val.length() <= numberCharMax) {
            int numberZero = numberCharMax - val.length();
            fixe.append("0".repeat(numberZero));
            fixe.append(val);

        } else {
            fixe = new StringBuilder(val);
        }
        return fixe.toString();
    }

    public static Pageable findAllByCriteria(Integer resultOutCome) {
        Sort sort = Sort.by("id").descending();
        return PageRequest.of(0, resultOutCome == null
                ? Integer.MAX_VALUE : resultOutCome, sort);
    }
}
