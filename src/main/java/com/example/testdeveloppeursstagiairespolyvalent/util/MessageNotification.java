package com.example.testdeveloppeursstagiairespolyvalent.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageNotification {
    public static String SUCCES = "1";
    public static String ERROR = "0";
    private int save = 0;
    private int update = 0;
    private int delete = 0;
    private String status;
    private String message;

    public MessageNotification(String message) {
        this.message = message;
        this.status = SUCCES;
    }

    public MessageNotification(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public MessageNotification(int save, int update, int delete, String status, String message) {
        this.save = save;
        this.update = update;
        this.delete = delete;
        this.status = status;
        this.message = message;
    }

    public Boolean isOk() {
        return SUCCES.equals(status);
    }

    public Boolean isError() {
        return ERROR.equals(status);
    }

}
