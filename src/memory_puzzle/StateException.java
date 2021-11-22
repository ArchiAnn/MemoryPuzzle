package memory_puzzle;

public class StateException extends Exception {
    public StateException() { super(); }
    public StateException(String message) { super(message); }
    public StateException(String message, Throwable t) { super(message, t); }
}
