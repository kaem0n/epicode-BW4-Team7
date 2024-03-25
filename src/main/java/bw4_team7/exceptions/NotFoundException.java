package bw4_team7.exceptions;
public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Errore: l'ID " + id + " non ha dato alcun risultato.");
    }
}
