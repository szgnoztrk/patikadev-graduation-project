package dev.patika.app.utility.results;

import lombok.Data;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success, String message){
        this(success);
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
