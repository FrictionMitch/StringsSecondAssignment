public class Part1 {
    String atgCodon = "ATG";
    int taaIndex;
    int tagIndex;
    int tgaIndex;

    public int findStopCodon(String dnaString,  int startIndex, String stopCodon) {

        int currentIndex = dnaString.indexOf(stopCodon, startIndex + stopCodon.length());
        while(currentIndex != -1) {
            int difference = currentIndex - startIndex;
            if (difference % 3 == 0) {
                return currentIndex;
            } else {
                currentIndex = dnaString.indexOf(stopCodon, currentIndex + 1);
            }
        }
        return -1;
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
        if ((taaIndex == -1) || (tagIndex != -1 && tagIndex < tgaIndex)) {
            minIndex = tagIndex;
        } else {
            minIndex = taaIndex;
        }
        if ((minIndex == -1) || (tgaIndex != -1 && tgaIndex < minIndex)) {
            minIndex = tgaIndex;
        }

        if(minIndex == -1){
            return "";
        }

        return dna.substring(startIndex, minIndex + atgCodon.length());
    }

    public void printAllGenes(String dna) {
        int startIndex = 0;
        while(true) {
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    public void testOn(String dna) {
        System.out.println("Testing \"printAllGenes\" on " + dna);
        printAllGenes(dna);
    }

    public void test() {
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        testOn("GATGTGAC");
    }
}
