package memory_puzzle;

public class PositionNichtInFeldException extends Exception {
    public PositionNichtInFeldException() { super(); }
    public PositionNichtInFeldException(String message) { super(message); }
    public PositionNichtInFeldException(String message, Throwable t) { super(message, t); }
}
