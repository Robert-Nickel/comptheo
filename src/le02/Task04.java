package le02;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task04 {

    /**
     * Schreiben Sie in Java eine Klasse „Validiere“, die für beliebige über die Standard-Eingabe eingelesene
     * Telefonnummern prüft, ob es sich um eine Konstanzer Telefonnummer handelt. Geben Sie über die Standard-Ausgabe
     * entsprechend „Konstanzer Telefonnummer“ oder „keine Konstanzer Telefonnummer“ aus.
     *
     * Hinweis: Sie dürfen die Java Library https://introcs.cs.princeton.edu/stdlib und die match-Methode der Java
     * Library String verwenden.
     */
    public static void main(String[] args) {
        StdOut.println("Enter the telephone number you suspect to belong to Konstanz.");
        while (StdIn.hasNextLine()) {
            String input = StdIn.readLine();
            if (matchesPhoneNumberFromKonstanz(input)) {
                StdOut.println("Belongs to Konstanz.");
            } else {
                StdOut.println("Doesn't belong to Konstanz.");
            }
        }
    }

    private static boolean matchesPhoneNumberFromKonstanz(final String input) {
        return input.matches("(\\+|\\+\\+|00)" +
                "497531" +
                "[0-9][0-9][0-9]" +
                "(|[0-9])(|[0-9])(|[0-9])(|[0-9])");
    }

    @Test
    void testMatchesPhoneNumberFromKonstanz() {
        assertTrue(matchesPhoneNumberFromKonstanz("+4975319000"));
        assertTrue(matchesPhoneNumberFromKonstanz("004975319000"));
        assertTrue(matchesPhoneNumberFromKonstanz("++4975319000"));
        assertTrue(matchesPhoneNumberFromKonstanz("+4975311234567"));
        assertTrue(matchesPhoneNumberFromKonstanz("+497531123"));

        assertFalse(matchesPhoneNumberFromKonstanz("4+975319000"));
        assertFalse(matchesPhoneNumberFromKonstanz("4975319000"));
        assertFalse(matchesPhoneNumberFromKonstanz("+++4975319000"));
        assertFalse(matchesPhoneNumberFromKonstanz("04975319000"));
        assertFalse(matchesPhoneNumberFromKonstanz("+49753112345678"));
        assertFalse(matchesPhoneNumberFromKonstanz("+49753112"));
        assertFalse(matchesPhoneNumberFromKonstanz("+4975319o0000")); // <- it a trap
    }
}
