package turing;

public class State {
    private String name;
    private String type;

    public State(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public boolean isHalt()  { return type.equals("H"); }
    public boolean isYes()   { return type.equals("Y"); }
    public boolean isNo()    { return type.equals("N"); }
    public boolean isLeft()  { return type.equals("L"); }
    public boolean isRight() { return type.equals("R"); }

    public String getName()  { return name; }

    public String toString() {
        return name + " " + type;
    }
}