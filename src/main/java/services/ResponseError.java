package services;

/**
 * Created by fatih on 3-2-2018.
 */
public class ResponseError {
    private String message;

    public ResponseError(String message, String... args) {
        this.message = String.format(message, args);
    }

    public ResponseError(Exception e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return this.message;
    }
}
