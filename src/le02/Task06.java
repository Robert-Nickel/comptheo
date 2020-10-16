package le02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task06 {

    /**
     * Gegeben sei der reguläre Ausdruck 1.*0|1 der Sprache L6.
     *
     * a. Geben Sie eine möglichst treffende, informelle Beschreibung von L6 an.
     * => Entweder 1 oder ein Wort, welches mit 1 beginnt, dann von beliebig vielen (oder keinem) Punkt gefolgt wird,
     * und zuletzt noch eine 0 hat.
     *
     * b. Geben Sie drei Wörter an, die Teil der regulären Sprache sind.
     * => 1, 10, 1.0
     *
     * c. Überprüfen Sie Ihre Wahl am Rechner.
     */
    private static boolean matchesRegex(final String input) {
        return input.matches("1\\.*0|1");
    }

    @Test
    void testMatchesPhoneNumberFromKonstanz() {
        assertTrue(matchesRegex("1"));
        assertTrue(matchesRegex("10"));
        assertTrue(matchesRegex("1.0"));
    }
}
