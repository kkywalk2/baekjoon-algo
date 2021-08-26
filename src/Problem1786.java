import java.util.ArrayList;
import java.util.Scanner;

public class Problem1786 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String txt = sc.nextLine();
        String pattern = sc.nextLine();

        int[] pi = getPi(pattern);
        ArrayList<Integer> matchList = kmp(pi, txt, pattern);

		for(int i : matchList) {
			sb.append(i).append(" ");
		}
		
		System.out.println(matchList.size());
		System.out.println(sb.toString());
        sc.close();
    }

    static int[] getPi(String str) {
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
        return pi;
    }

    static ArrayList<Integer> kmp(int[] pi, String txt, String pattern) {
        int j = 0;
        int strLen = txt.length();
        int patternLen = pattern.length();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < strLen; i++) {
            while (j > 0 && txt.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (txt.charAt(i) == pattern.charAt(j)) {
                if (j + 1 == patternLen) { 
                    list.add(i - patternLen + 2); 
                    j = pi[j];
                } else { 
                    j++;
                }
            }
        }

        return list;
    }
}