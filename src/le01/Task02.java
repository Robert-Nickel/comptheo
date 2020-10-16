package le01;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.List;

public class Task02 {

    /**
     * Schreiben Sie in Java eine Klasse „Validiere“, die für beliebige über die Standard-Eingabe eingelesene
     * Postleitzahlen (PLZ) prüft, ob es sich um eine Konstanzer PLZ handelt. Geben Sie über die Standard-Ausgabe
     * entsprechend „Konstanzer PLZ“ oder „keine Konstanzer PLZ“ aus.
     *
     * Hinweis: Nehmen Sie an, dass die Eingabe aus Zahlen besteht. Sie dürfen die Java Library
     * https://introcs.cs.princeton.edu/stdlib verwenden.
     */

    public static void main(String[] args) {
        final List<String> postalCodesKonstanz = List.of("78462", "78464", "78465", "78467");
        StdOut.println("Enter the postal code you suspect to belong to Konstanz.");

        while (StdIn.hasNextLine()) {
            String input = StdIn.readLine();
            if (postalCodesKonstanz.contains(input)) {
                StdOut.println("Belongs to Konstanz");
            } else {
                StdOut.println("Doesn't belong to Konstanz");
            }
        }
    }
}
