package Data.Message;

public class Response {
    private ResponseStatus statue;
    private String message;

    public Response(ResponseStatus statue, String message) {
        this.statue = statue;
        this.message = message;
    }

    public ResponseStatus getStatue() {
        return statue;
    }

    public String getMessage() {
        return message;
    }
}
