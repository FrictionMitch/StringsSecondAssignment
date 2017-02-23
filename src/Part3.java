public class Part3 {
    int taaIndex;
    int tagIndex;
    int tgaIndex;

    int total;
    int geneTotal;

    public int findStopCodon(String dnaString, int startIndex, String stopCodon) {
        int currentIndex = dnaString.indexOf(stopCodon, startIndex + stopCodon.length());

        while(currentIndex != -1) {
            int difference = currentIndex - startIndex;
            if(difference % 3 == 0) {
                return currentIndex;
            } else {
                currentIndex = dnaString.indexOf(stopCodon, currentIndex + 1);
            }
        }
        return - 1;
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

        return dna.substring(startIndex, minIndex + 3);
    }

    public void countAllGenes(String dna) {
        int startIndex = 0;
        geneTotal = 0;
        while(true) {
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            geneTotal++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        System.out.println(geneTotal + " gene(s) found");
    }

    public int howMany(String gene, String dna) {
        int startIndex = 0;
        total = 0;
        while (true) {
            int currentIndex = dna.indexOf(gene, startIndex);
            startIndex = currentIndex + gene.length();
            if (currentIndex == -1) {
                break;
            } else {
                total++;
            }
        }

        return total;
    }

    public void testHowMany() {
        String A = "A";
        String B = "ABA";
        howMany(A, B);
        System.out.printf("There are %d %s's in %s%n%n", total, A, B);
    }

    public void testOn(String dna) {
        System.out.println("Testing \"printAllGenes\" on " + dna);
        countAllGenes(dna);
    }

    public void test() {
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        testOn("GATGTGACATGTAAATGTAGATATTTATGTAG");
    }
}
