package le03;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task02 {

    public static void main(final String[] args) {
        final DFA dfa = new DFA("le03/Task02Dfa.txt");
        while (StdIn.hasNextLine()) {
            StdOut.println(dfa.simulate(StdIn.readLine()));
        }
    }

    @Test
    void test() {
        final DFA dfa = new DFA("le03/Task02Dfa.txt");
        assertEquals("yes", dfa.simulate("aa"));
        assertEquals("yes", dfa.simulate("ab"));
        assertEquals("yes", dfa.simulate("bab"));
        assertEquals("yes", dfa.simulate("aab"));

        assertEquals("no", dfa.simulate("bb"));
        assertEquals("no", dfa.simulate("ba"));
    }
}
