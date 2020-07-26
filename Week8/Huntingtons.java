/* *****************************************************************************
Huntington’s disease is an inherited and fatal neurological disorder. Although there
is currently no cure, in 1993 scientists discovered a very accurate genetic test. The
gene that causes Huntington’s disease is located on chromosome 4 and has a variable
number of (consecutive) repeats of the CAG trinucleotide. The normal range of CAG
repeats is between 10 and 35. Individuals with Huntington’s disease have between 36
and 180 repeats. Doctors can use a PCR-based DNA test; count the maximum number of
repeats; and use the following table to generate a diagnosis:
Huntingtons.java to analyze a DNA string for Huntington’s disease and produce a diagnosis.
 **************************************************************************** */

public class Huntingtons {


    public static int maxRepeats(String dna) {
        if (dna.length() < 3)
            return 0;
        int pointer = 0;
        int occ = dna.indexOf("CAG", pointer);
        int maxlength = 0;
        while (occ >= 0) {

            int currentlength = 0;
            int i;
            for (i = occ; i < dna.length() - 2; i += 3) {
                if (dna.substring(i, i + 3).equals("CAG")) {
                    currentlength++;
                }
                else {
                    break;
                }
            }
            pointer = i + 1;
            if (currentlength > maxlength)
                maxlength = currentlength;

            occ = dna.indexOf("CAG", pointer);
        }
        return maxlength;
    }

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    // public static int maxRepeats(String dna) {
    //     int maxlength = 0;
    //     for (int i = 0; i < dna.length() - 2; i++) {
    //
    //         int currentlength = 0;
    //         while (dna.substring(i, i + 3).equals("CAG") && i < dna.length() - 2) {
    //             currentlength++;
    //             i += 3;
    //         }
    //
    //         if (currentlength > maxlength)
    //             maxlength = currentlength;
    //     }
    //     return maxlength;
    // }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace(" ", "").replace("\n", "").replace("\t", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10)
            return "not human";
        else if (maxRepeats < 36)
            return "normal";
        else if (maxRepeats < 40)
            return "high risk";
        else if (maxRepeats < 181)
            return "Huntington’s";
        else
            return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String seq = in.readAll();
        seq = removeWhitespace(seq);
        int maxCAG = maxRepeats(seq);
        System.out.println("max repeats = " + maxCAG);
        System.out.println(diagnose(maxCAG));

    }
}
