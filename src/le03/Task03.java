package le03;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Zeichnen Sie einen DFA, der alle Wörter über dem Alphabet Σ = {a, b, c}
 * mit mindestens einem a, einem b und einem c akzeptiert.
 */
public class Task03 {
    public static void main(final String[] args) {
        final DFA dfa = new DFA("le03/Task03Dfa.txt");
        while (StdIn.hasNextLine()) {
            StdOut.println(dfa.simulate(StdIn.readLine()));
        }
    }

    @Test
    void test() {
        final DFA dfa = new DFA("le03/Task03Dfa.txt");
        assertEquals("yes", dfa.simulate("abc"));
        assertEquals("yes", dfa.simulate("aaabc"));
        assertEquals("yes", dfa.simulate("abbbc"));
        assertEquals("yes", dfa.simulate("abccc"));
        assertEquals("yes", dfa.simulate("cba"));
        assertEquals("yes", dfa.simulate("bac"));
        assertEquals("yes", dfa.simulate("cba"));
        assertEquals("yes", dfa.simulate("cbcbcbaaa"));

        assertEquals("no", dfa.simulate("a"));
        assertEquals("no", dfa.simulate("b"));
        assertEquals("no", dfa.simulate("c"));
        assertEquals("no", dfa.simulate("ab"));
        assertEquals("no", dfa.simulate("bc"));
        assertEquals("no", dfa.simulate("ac"));
        assertEquals("no", dfa.simulate("ababab"));
        assertEquals("no", dfa.simulate("aaaacccc"));
    }
}
