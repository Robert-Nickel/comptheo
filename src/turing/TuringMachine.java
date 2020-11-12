package turing;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;

import java.io.File;

/******************************************************************************
 *  Compilation:  javac TuringMachine.java
 *  Execution:    java TuringMachine
 *  Dependencies: Stack.java Tape.java Transition.java
 *
 *  % java TuringMachine comparator.tur "1101<1110"
 *
 *  Reads in a .tur file describing a Turing machine, and simulates
 *  the input on the machine.
 *
 ******************************************************************************/

public class TuringMachine {
    private int start;
    private String[] action;
    private ST<Character, Integer>[] next;
    private ST<Character, Character>[] out;

    public TuringMachine(String pathToTurFile) {
        In in = new In(new File(ClassLoader.getSystemResource(pathToTurFile).getFile()));
        int n = in.readInt();
        String alphabet = in.readString();
        start = in.readInt();
        action = new String[n];
        next = (ST<Character, Integer>[]) new ST[n];
        out = (ST<Character, Character>[]) new ST[n];
        for (int st = 0; st < n; st++) {
            action[st] = in.readString();
            if (action[st].equals("H") || action[st].equals("Y") || action[st].equals("N"))
                continue;

            next[st] = new ST<Character, Integer>();

            for (int i = 0; i < alphabet.length(); i++) {
                int state = in.readInt();
                next[st].put(alphabet.charAt(i), state);
            }

            out[st] = new ST<Character, Character>();
            for (int i = 0; i < alphabet.length(); i++) {
                char symbol = in.readString().charAt(0);
                out[st].put(alphabet.charAt(i), symbol);
            }
        }
    }

    public String simulate(String input) {
        Tape tape = new Tape(input);
        int state = start;
        while (action[state].equals("L") || action[state].equals("R")) {
            if (action[state].equals("R")) tape.moveRight();
            if (action[state].equals("L")) tape.moveLeft();
            char c = tape.read();
            tape.write(out[state].get(c));
            state = next[state].get(c);
        }
        return action[state] + " " + tape;
    }

    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine(args[0]);
        while (StdIn.hasNextLine()) {
            String input = StdIn.readLine();
            StdOut.println(tm.simulate(input));
        }
    }
}

