package memory_puzzle;

public class KarteBereitsAufgedecktException extends Exception {
    public KarteBereitsAufgedecktException() { super(); }
    public KarteBereitsAufgedecktException(String message) { super(message); }
    public KarteBereitsAufgedecktException(String message, Throwable t) { super(message, t); }
}
