package kaem0n.exceptions;
public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Error: queried ID " + id + " gave no results.");
    }
    public NotFoundException(String isbn) {
        super("Error: queried ISBN " + isbn + " gave no results.");
    }
}
