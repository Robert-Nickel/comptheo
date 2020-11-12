package turing;

public class Tape {
    private Stack<Character> left  = new Stack<Character>();   // left part of tape
    private Stack<Character> right = new Stack<Character>();   // right part of tape
    private char current;                                      // current symbol
    private final static char BLANK = '#';

    // allocate, initialize, and return a Tape with the specified input
    public Tape(String input) {
        right.push(BLANK);
        for (int i = input.length() - 1; i >= 0; i--) {
            right.push(input.charAt(i));
        }
        current = right.pop();
    }

    // move tape head left one position
    public void moveLeft() {
        right.push(current);
        if (left.isEmpty()) left.push(BLANK);  // increase size of tape if necessary
        current = left.pop();
    }

    // move tape head right one position
    public void moveRight() {
        left.push(current);
        if (right.isEmpty()) right.push(BLANK);  // increase size of tape if necessary
        current = right.pop();
    }

    // set and get the symbol stored in the active cell
    public char read()             { return current;    }
    public void write(char symbol) { current = symbol;  }


    // return a reversed version of the string s
    public static String reverse(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String left = s.substring(0, N/2);
        String right = s.substring(N/2, N);
        return reverse(right) + reverse(left);
    }

    // show representation of tape
    public String toString() {
        return reverse(left.toString()) + "|" + current + "|" + right;
    }

}