package le05;

import edu.princeton.cs.introcs.StdOut;
import org.junit.jupiter.api.Test;
import turing.TuringMachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3 {

    @Test
    void testE() {
        final TuringMachine turingMachine = new TuringMachine("le05/Task03TuringMachine.txt");
        StdOut.print(turingMachine.simulate("11011011"));
        assertEquals("3  1|#|0 1 1 0 1 1 # ", turingMachine.simulate("11011011"));
    }
}
