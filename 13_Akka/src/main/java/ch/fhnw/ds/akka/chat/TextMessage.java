package ch.fhnw.ds.akka.chat;

public class TextMessage extends ChatMessage {

    private final String message;

    public TextMessage(String username, String message) {
        super(username);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
