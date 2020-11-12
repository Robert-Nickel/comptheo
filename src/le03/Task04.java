package le03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Zeichnen Sie einen DFA, der alle binären Wörter über dem Alphabet Σ = {a, b} akzeptiert,
 * bei denen...
 */
public class Task04 {

    /**
     * ...ein Vielfaches von zwei a’s vorkommt.
     */
    @Test
    void testA() {
        final DFA dfa = new DFA("le03/Task04aDfa.txt");
        assertEquals("yes", dfa.simulate("aa"));
        assertEquals("yes", dfa.simulate(""));
        assertEquals("yes", dfa.simulate("aaaa"));
        assertEquals("yes", dfa.simulate("abababa"));
        assertEquals("yes", dfa.simulate("babababab"));

        assertEquals("no", dfa.simulate("a"));
        assertEquals("no", dfa.simulate("aaa"));
        assertEquals("no", dfa.simulate("ababa"));
        assertEquals("no", dfa.simulate("bababab"));
    }

    @Test
    void testB() {
        final DFA dfa = new DFA("le03/Task04bDfa.txt");
        assertEquals("yes", dfa.simulate(""));
        assertEquals("yes", dfa.simulate("bbb"));
        assertEquals("yes", dfa.simulate("bbbbbb"));
        assertEquals("yes", dfa.simulate("bababababab"));
        assertEquals("yes", dfa.simulate("ababababababa"));

        assertEquals("no", dfa.simulate("b"));
        assertEquals("no", dfa.simulate("bb"));
        assertEquals("no", dfa.simulate("aabbaa"));
        assertEquals("no", dfa.simulate("bababab"));
        assertEquals("no", dfa.simulate("ababababa"));
    }
}
