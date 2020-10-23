package le03;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

import java.io.File;

public class DFA {
    private final String[] states;
    private final ST<Character, Integer>[] transitions;

    /**
     * @param pathToDfaFile: The pathToDfaFile has to have the following format:
     *            number of states
     *            the alphabet
     *            then for each state:
     *            the name of the state, then a space, then the transitions space-separated
     *
     *            Example:
     *            2
     *            ab
     *            yes 0 1
     *            no 1 0
     */
    public DFA(final String pathToDfaFile) {
        final In in = new In(new File(ClassLoader.getSystemResource(pathToDfaFile).getFile()));
        int numberOfStates = in.readInt();
        states = new String[numberOfStates];

        final String alphabet = in.readString();
        transitions = new ST[numberOfStates];

        for (int i = 0; i < numberOfStates; i++) {
            states[i] = in.readString();
            transitions[i] = new ST<>();
            for (int j = 0; j < alphabet.length(); j++) {
                transitions[i].put(alphabet.charAt(j), in.readInt());
            }
        }
    }

    public String simulate(final String input) {
        int state = 0;
        for (int i = 0; i < input.length(); i++) {
            state = transitions[state].get(input.charAt(i));
        }
        return states[state];
    }
}
