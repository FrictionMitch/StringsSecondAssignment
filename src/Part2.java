public class Part2 {

    int total;

    public int howMany(String stringA, String stringB) {
        int startIndex = 0;
        total = 0;
        while (true) {
            int currentIndex = stringB.indexOf(stringA, startIndex);
            startIndex = currentIndex + stringA.length();
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

        A = "A";
        B = "AABAA";
        howMany(A, B);
        System.out.printf("There are %d %s's in %s%n%n", total, A, B);

        A = "C";
        B = "CUCUMBER CUTTING MACHINE";
        howMany(A, B);
        System.out.printf("There are %d %s's in %s%n%n", total, A, B);
    }
}
