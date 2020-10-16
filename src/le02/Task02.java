package le02;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task02 {

    /**
     * Bestimmen Sie in Java einen regulären Ausdruck, der alle IP-Adressen der HTWG-Konstanz beschreibt.
     * • Recherchieren Sie, welche Spezifika die IP-Adressen (wir nehmen hier noch ipv4) der HTWG kennzeichnen.
     * • Stellen Sie sicher, dass neben diesen Spezifika, auch das grundsätzliche IP-Format eingehalten wird:
     * o 4 Ziffernblöcken, die aufeinander folgen.
     * o jeder Ziffernblock aus 1, 2 oder 3 Zahlen besteht.
     * o die Ziffernblöcke ein Punkt („.“) voneinander trennt.
     * <p>
     * Hinweis: Sie dürfen die Java Library https://introcs.cs.princeton.edu/stdlib und die match-Methode der Java
     * Library String verwenden.
     */

    public static void main(String[] args) {
        StdOut.println("Please enter the ipv4 address you suspect to belong to the HTWG Konstanz");
        while (StdIn.hasNextLine()) {
            String input = StdIn.readLine();
            if (matchesHTWGIpv4Address(input)) {
                StdOut.println("Belongs to HTWG Konstanz");
            } else {
                StdOut.println("Doesn't belong to HTWG Konstanz");
            }
        }
    }

    private static boolean matchesHTWGIpv4Address(final String input) {
        return input.matches("141.37.20.(" +
                "[0-9]|" +
                "[1-9][0-9]|" +
                "1[1-9][0-5]|" +
                "2[0-5][0-5])");
    }

    @Test
    void testMatchesHTWGIpv4Address() {
        assertTrue(matchesHTWGIpv4Address("141.37.20.0"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.9"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.11"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.15"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.111"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.255"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.170"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.201"));
        assertTrue(matchesHTWGIpv4Address("141.37.20.250"));

        assertFalse(matchesHTWGIpv4Address(""));
        assertFalse(matchesHTWGIpv4Address("wrong"));
        assertFalse(matchesHTWGIpv4Address("141.37.20.256"));
        assertFalse(matchesHTWGIpv4Address("142.37.20.255"));
        assertFalse(matchesHTWGIpv4Address("141.38.20.255"));
        assertFalse(matchesHTWGIpv4Address("141.37.21.255"));
        assertFalse(matchesHTWGIpv4Address("ITI.SW.RO.NG!"));
        assertFalse(matchesHTWGIpv4Address("141.37.20.000"));
        assertFalse(matchesHTWGIpv4Address("141.37.20.011"));
        assertFalse(matchesHTWGIpv4Address("141.37.20.01"));
        assertFalse(matchesHTWGIpv4Address("300.37.20.01"));
    }
}
