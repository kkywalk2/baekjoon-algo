package baekjoon;
import java.util.Scanner;

public class Problem4354 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str;
        while (!((str = sc.nextLine()).equals("."))) {
            int max = getMaxPi(str);
            sb.append(max).append("\n");
        }

        System.out.print(sb);
        sc.close();
    }

    static int getMaxPi(String str) {
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
        return len % (len - pi[len - 1]) != 0 ? 1 : len / (len - pi[len - 1]);
    }
}