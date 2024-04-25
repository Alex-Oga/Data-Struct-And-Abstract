public class Diamond {

    public static void printDiamond(int k) {

        String hash = "#";
        String star = "*";
        int cycle = 2*k-1;
        int repeatHash = k+1;
        int repeatStar = -1;

        for (int i=0; i < cycle; i++) {
            if (i <= cycle/2) {
                repeatStar += 2;
                repeatHash -= 1;
                System.out.println(hash.repeat(repeatHash) + star.repeat(repeatStar) + hash.repeat(repeatHash));
            }
            else {
                repeatStar -= 2;
                repeatHash += 1;
                System.out.println(hash.repeat(repeatHash) + star.repeat(repeatStar) + hash.repeat(repeatHash));
            }
        }

    }
}
