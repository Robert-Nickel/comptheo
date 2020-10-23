package le03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Gegeben sei ein Automat, der alle binären Wörter über dem Alphabet Σ = {a, b} akzeptiert, die auf „ab“ enden.
 */
public class Task01 {
    /**
     * a. Zeichnen Sie einen DFA mit vier Zuständen.
     * Für die Endungen aa, ab, ba und bb soll jeweils ein separater Zustand angenommen werden.
     */
      @Test
    void testA() {
        final DFA dfa = new DFA("le03/Task01aDfa.txt");
        assertEquals("yes", dfa.simulate("ab"));
        assertEquals("yes", dfa.simulate("aaab"));
        assertEquals("yes", dfa.simulate("ababab"));
        assertEquals("yes", dfa.simulate("bbbab"));

        assertEquals("no3", dfa.simulate("aa"));
        assertEquals("no1", dfa.simulate("bb"));
        assertEquals("no2", dfa.simulate("ba"));
        assertEquals("no1", dfa.simulate("abb"));
    }

    /**
     * b. Zeichnen Sie einen DFA mit der gleichen Aufgabe, aber nur drei Zuständen.
     */
    @Test
    void testB() {
        final DFA dfa = new DFA("le03/Task01bDfa.txt");
        assertEquals("yes", dfa.simulate("ab"));
        assertEquals("yes", dfa.simulate("aaab"));
        assertEquals("yes", dfa.simulate("ababab"));
        assertEquals("yes", dfa.simulate("bbbab"));

        assertEquals("no", dfa.simulate("aa"));
        assertEquals("no", dfa.simulate("bb"));
        assertEquals("no", dfa.simulate("ba"));
        assertEquals("no", dfa.simulate("abb"));
    }
}
