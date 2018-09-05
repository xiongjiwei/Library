package Data.Message;

public class Request {
    private RequestOption option;
    private String message;

    public Request(RequestOption option, String message) {
        this.option = option;
        this.message = message;
    }

    public Request(RequestOption option) {
        this.option = option;
    }

    public RequestOption getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
