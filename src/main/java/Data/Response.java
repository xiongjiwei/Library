package Data;

public class Response {
    private int statue;
    private String message;

    public Response(int statue, String message) {
        this.statue = statue;
        this.message = message;
    }

    public int getStatue() {
        return statue;
    }

    public String getMessage() {
        return message;
    }
}
