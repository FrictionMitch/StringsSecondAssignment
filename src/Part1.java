public class Part1 {
    String atgCodon = "ATG";
    int taaIndex;
    int tagIndex;
    int tgaIndex;

    public int findStopCodon(String dnaString,  int startIndex, String stopCodon) {
        int currentIndex = dnaString.indexOf(stopCodon, startIndex + stopCodon.length());
        while(currentIndex != -1) {

        }
    }

    public String findGene(String dna, int position) {
        int startIndex = dna.indexOf("ATG", position);
        if (startIndex == -1) {
            return "";
        }

        taaIndex = findStopCodon(dna, startIndex, "TAA");
        tagIndex = findStopCodon(dna, startIndex, "TAG");
        tgaIndex = findStopCodon(dna, startIndex, "TGA");

        // Find which of the stop codons comes first
        int minIndex = 0;

    }
}
