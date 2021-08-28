import java.util.Scanner;

public class Problem1305 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        String pattern = sc.nextLine();

        System.out.println(length - getLastPi(pattern));
        sc.close();
    }

    static int getLastPi(String str) {
        int j = 0;
        int len = str.length();
        int[] pi = new int[len];

        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return j;
    }
}