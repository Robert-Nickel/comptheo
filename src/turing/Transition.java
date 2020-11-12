package turing;

public class Transition {
    public final static String DELIMITER = "|";
    private State from, to;
    private String read, write;

    public Transition(State from, State to, String read, String write) {
        this.from = from;
        this.to = to;
        this.read = read;
        this.write = write;
    }

    public String getWrite()    { return write; }
    public State getNextState() { return to;    }

    public String toString() {
        return "from: " + from + ", to: " + to + ", read: " + read + ", write: " + write;
    }
}