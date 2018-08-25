package view;

/**
 * Created by fatih on 3-2-2018.
 */
class ResponseError {
    private String message;

    ResponseError(String message, String... args) {
        this.message = String.format(message, args);
    }

    ResponseError(Exception e) {
        this.message = e.getMessage();
    }

    String getMessage() {
        return this.message;
    }
}
